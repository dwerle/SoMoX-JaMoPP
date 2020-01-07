package org.somox.analyzer.simplemodelanalyzer.indirCommDetection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* containing everything regarding jms
 * TODO dsg8fe refactor */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Role;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.arrays.ArrayInstantiation;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.expressions.AssignmentExpressionChild;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.types.Type;


public abstract class JMSDetection {
	
	static HashMap<String, ArrayList<Role>> mapRolesToDestination = new HashMap<String, ArrayList<Role>>();
	
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
		
		ConcreteClassifier parent = statement.getParentConcreteClassifier();
		String name = parent.getClass().getName();
		// ConcreteClassifier parentparent.getParentConcreteClassifier();
				
        final TreeIterator<EObject> treeIterator = statement.eAllContents();
        while (treeIterator.hasNext()) {
            final EObject current = treeIterator.next();
            
            // System.out.println(current.getClass().getName());
            if (current instanceof MethodCall) {
                final MethodCall methodCall = (MethodCall) current;
                ReferenceableElement rel_mc =  methodCall.getTarget();
                if (rel_mc instanceof Method)
                {

                		String dir = "C:\\Users\\Kpt. Zusel\\eclipse - Kopie - Kopie\\modeling-2018-09\\runtime-InnerEclipse\\EnvironmentMonitoring\\src\\main\\java";
	                	//String dir = "C:\\Users\\Kpt. Zusel\\eclipse - Kopie - Kopie\\modeling-2018-09\\runtime-InnerEclipse\\JmsEasy\\src\\main\\java";
	                	String dest_var_name = null;
	                	if (isNormalSenderMethod((Method)rel_mc)) {
	                    	Expression arg = methodCall.getArguments().get(0);         	
	                		if (arg instanceof IdentifierReference) {
		                		dest_var_name = ((IdentifierReference) arg).getTarget().getName();
	                		}
	                	} else if (isNormalReceiverMethod((Method)rel_mc)) {
	                		dest_var_name = findValueOfVariable("MessageConsumer (.+) = (.+).createConsumer\\((.+)\\)", dir, 3);
	                	} else {
	                		System.out.println("JMSDetection: Neither Receiver nor Sender"); // TODO dsg8fe throw exception
	                		return null;
	                	}
	                	
	                	destination = findValueOfVariable("Queue "+dest_var_name+" = \\(Queue\\) (.+).lookup\\(\"(.+)\"\\)", dir, 2);
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
	
	public static ArrayList<Role> getConntectedRolesToRole(Role role) {
		String destination = null;
		Set<Entry<String, ArrayList<Role>>> set = mapRolesToDestination.entrySet();
		Iterator<Entry<String, ArrayList<Role>>> iterator = set.iterator();
		
		while(iterator.hasNext() && null == destination ) {
			Map.Entry mentry = (Map.Entry)iterator.next();
	        Iterator<Role> roleIterator = ((ArrayList<Role>) mentry.getValue()).iterator();
 			while (roleIterator.hasNext()) {
	 			if (roleIterator.next().equals(role)) {
	 				destination = (String) mentry.getKey();
	 				break;
	 			}
 			}
 		}
	      
		return null;
		
	}
	
	static String findValueOfVariable(String var, String dir, int numberOfGroup)
	{
		String value = null;
		
        ArrayList<File> files = getPaths(new File(dir), new ArrayList<File>());
        if(files != null) {
	        try {
	            for (int i = 0; i < files.size(); i++)
	            {
	            	String patternToFind = var;
	            	Pattern m = Pattern.compile(patternToFind);
	            	
	            	try (Stream<String> lines = Files.lines(files.get(i).toPath())) {
	            	    Optional<String> message = lines.filter(m.asPredicate()).findFirst();
	            	    if (message.isPresent()) {
	            	        Matcher matcher = m.matcher(message.get());
	            	        matcher.find();
	            	        String group = matcher.group(numberOfGroup);
	            	        System.out.println(group);
	            	        
	            	        value = group;
	            	    }
	            	}
	            	
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        
		
		return value;
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
    	if (method.getName().equals("receive")) { // TODO dsg8fe regex
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
