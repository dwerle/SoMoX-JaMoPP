package indirCommDetection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

/* containing everything regarding jms
 * TODO dsg8fe refactor */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.types.ClassifierReference;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;

public abstract class JMSDetection {
	
	static HashMap<String, ArrayList<Role>> mapRolesToDestination = new HashMap<String, ArrayList<Role>>();
	
	static private JMSPatternAndApiHandler jmsPatternHandler = new JMSPatternAndApiHandler();
	
	static private List<File> files = new ArrayList<File>();

	// Nutzte sie weise und selten, sie enthaelt mehrere Schleifen und ist somit Ressourcen intensiv TODO translate
	public static boolean isSinkAndSourceRoleConnected(SinkRole sinkRole, SourceRole sourceRole)
	{
		String destination = null;
		boolean sinkRoleFound = false;
		boolean sourceRoleFound = false;
		Set<Entry<String, ArrayList<Role>>> set = mapRolesToDestination.entrySet();
		Iterator<Entry<String, ArrayList<Role>>> iterator = set.iterator();
		
		while(iterator.hasNext() && null == destination ) {
			Map.Entry mentry = (Map.Entry)iterator.next();
	        Iterator<Role> roleIterator = ((ArrayList<Role>) mentry.getValue()).iterator();
	        
	        sinkRoleFound = false;
	        sourceRoleFound = false;
 			while (roleIterator.hasNext()) {
 				Role r = roleIterator.next();
	 			if (r != null && r.equals(sinkRole)) {
	 				sinkRoleFound = true;
	 			}
	 			if (r != null && r.equals(sourceRole)) {
	 				sourceRoleFound = true;
	 			}
	 			
	 			if (sinkRoleFound && sourceRoleFound) {
	 				return true;
	 			}
	 		}
 		}
		
		return false;
	}
	
	public static String parseStatementForDestination(Statement statement) {
		String destination = null;

		String clazzname = statement.getParentConcreteClassifier().getName();
		
        final TreeIterator<EObject> treeIterator = statement.eAllContents();
        while (treeIterator.hasNext()) {
            final EObject current = treeIterator.next();
            
            // System.out.println(current.getClass().getName());
            if (current instanceof MethodCall) {
                final MethodCall methodCall = (MethodCall) current;
                ReferenceableElement rel_mc =  methodCall.getTarget();
                if (rel_mc instanceof Method)
                {
                		// TODO dsg8fe SourceCodeDecoratorRepository -> Component -> Statements
                		String dir = "C:\\Users\\Kpt. Zusel\\eclipse - Kopie - Kopie\\modeling-2018-09\\runtime-InnerEclipse\\EnvironmentMonitoring\\src\\main\\java";

                		String dest_var_name = null;
	                	if (isNormalSenderMethod((Method)rel_mc)) {
	                    	Expression arg = methodCall.getArguments().get(0);
	                		if (arg instanceof IdentifierReference) {
	                			/* Check if anonymous sender */
	                			/* Either the first Parameter is child of Message or of Destination, check if it is Destination */
	                			boolean isDestination = false;
	                			EList<ClassifierReference> list = ((IdentifierReference) arg).getType().getContainingConcreteClassifier().getSuperTypeReferences();
	                		    Iterator itr = list.listIterator();
	                		      
	                		      while(itr.hasNext()) {
	                		    	  ClassifierReference element = (ClassifierReference) itr.next();
	                		    	  if (element.getTarget().getName().equals("Destination")) {
	                		    		  isDestination = true;
	                		    	  }
	                		      }
	                		      
	                		    if (true == isDestination) {
	                		    	dest_var_name = ((IdentifierReference) arg).getTarget().getName();
	                		    } else {
	                		    	dest_var_name = findValueInPatterns(jmsPatternHandler.getCreateProducerPatterns(), dir, jmsPatternHandler.getGroupNrcreateProducerPatterns(), clazzname);
	                		    }
	                		}
	                	} else if (isNormalReceiverMethod((Method)rel_mc)) {
	                		dest_var_name = findValueInPatterns(jmsPatternHandler.getCreateReceiverPatterns(), dir, jmsPatternHandler.getGroupNrcreateReceiverPatterns(), clazzname);
	                	} else {
	                		System.out.println("JMSDetection: Neither Receiver nor Sender"); // TODO dsg8fe throw exception
	                		return null;
	                	}
	                	destination = findValueInPatterns(jmsPatternHandler.getLookupPattern(dest_var_name), dir, jmsPatternHandler.getGroupNrForLookupPattern(), clazzname);
	                	if (destination == null) {
	                		// TODO dsg8fe Exception
	                		System.out.println("No destination found for dest_var_name: " + dest_var_name);
	                	}
	             }
                
            }
        }
		return destination;
		
	}
	
	public static void setRoleConnectedToDestination(String destination, Role role)
	{
		if (mapRolesToDestination.containsKey(destination)) {
			
			mapRolesToDestination.get(destination).add(role);
		} else {
			ArrayList<Role> roles = new ArrayList<Role>();
			roles.add(role);
			mapRolesToDestination.put(destination, roles);
		}
	}
	
	public static ArrayList<Role> getRolesConnectedToDestination(String destination) {
		return mapRolesToDestination.get(destination);
	}

	static String findValueInPatterns(List<Pattern> pattern, String dir, List<Integer> numberOfGroups, String clazz) {
		ArrayList<String> results = new ArrayList<String>();
		if (pattern.size() != numberOfGroups.size()) {
			// TODO dsg8fe exception 
			return null;
		}
		if (files.isEmpty())
		{
			files = getPaths(new File(dir), new ArrayList<File>());
		}
		
        if(files != null) {
	        try {
	            for (int i = 0; i < files.size(); i++)
	            {
	            	if (files.get(i).getName().contains(clazz)) {
		            	String line;
	            	    File initialFile = new File(files.get(i).getAbsolutePath());
	            	    InputStream inputStream = new FileInputStream(initialFile);
	            	    InputStreamReader isr = new InputStreamReader (inputStream);
	            	    BufferedReader buf = new BufferedReader (isr);
	
	                    while ((line = buf.readLine ()) != null) 
	                    {
	                        for (int j = 0; j < pattern.size(); j++) 
	                        {
	                            Matcher m = pattern.get(j).matcher (line);
	                            while (m.find ()) 
	                            	results.add (m.group(numberOfGroups.get(j)));
	                        }
	                    }
	                    buf.close();
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        
        if (results != null && !results.isEmpty()) {
        	return results.get(0);
        } else {
        	return null;
        } 
	}

    private static ArrayList<File> getPaths(File file, ArrayList<File> list) {
        if (file == null || list == null || !file.isDirectory())
            return null;
        File[] fileArr = file.listFiles();
        for (File f : fileArr) {
            if (f.isDirectory()) {
                getPaths(f, list);
            } else {
            list.add(f);
            }
        }
        return list;
    } 
    
    static boolean isNormalSenderMethod(Method method) {
    	if (method.getName().equals("send")) { // TODO dsg8fe regex
    		return true;
    	} else {
    		return false;
    	}
    }
    
    static boolean isNormalReceiverMethod(Method method) {
    	if (method.getName().equals("receive")) { 
    		return true;
    	} else {
    		return false;
        	}
    }

	public static boolean isReceiver(Method method) {
		return isNormalReceiverMethod(method);
	}

	public static boolean isProducer(Method method) {
		return isNormalSenderMethod(method);
	}
	
	public static boolean isProducerClass(ConcreteClassifier clazz) {
		boolean isProducerClass = false;
		if (clazz.getName().equals("MessageProducer")) {
			isProducerClass = true;
		} else {
			isProducerClass = false;
		}
		
		return isProducerClass;
	}
	
	public static boolean isReceiverClass(ConcreteClassifier clazz) {
		boolean isReceiverClass = false;
		if (clazz.getName().equals("MessageConsumer")) {
			isReceiverClass = true;
		} else {
			isReceiverClass = false;
		}
		
		return isReceiverClass;
	}

	public static int getNumberOfProvidedJmsInterfaces(ComponentImplementingClassesLink componentCandidate) {
		int rolecounter = 0;
		for (final ProvidedRole role : componentCandidate.getComponent().getProvidedRoles_InterfaceProvidingEntity()) {
			if (role instanceof SinkRole ) {
				rolecounter++;
			}
		}
		return rolecounter;
	}

	public static int getNumberOfRequiredJmsInterfaces(ComponentImplementingClassesLink componentCandidate) {
		int rolecounter = 0;
		for (final RequiredRole role : componentCandidate.getComponent().getRequiredRoles_InterfaceRequiringEntity()) {
			if (role instanceof SourceRole ) {
				rolecounter++;
			}
		}
		return rolecounter;
	}

}
