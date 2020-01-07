package indirCommDetection.builder;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.Type;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.builder.AbstractBuilder;
import org.somox.analyzer.simplemodelanalyzer.builder.ComponentAndTypeNaming;
import org.somox.analyzer.simplemodelanalyzer.detection.IComponentInterfaceStrategy;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.kdmhelper.KDMHelper;
import org.somox.kdmhelper.metamodeladdition.Root;

public class EventRelElementsBuilder extends AbstractBuilder {
	private int egCounter = 0;
	
	private final Map<Type, EventGroup> alreadyCreatedEvents = new HashMap<Type, EventGroup>();
	
	private static Logger logger = Logger.getLogger(EventRelElementsBuilder.class);
	
    public EventRelElementsBuilder(Root astModel, SoMoXConfiguration somoxConfiguration, AnalysisResult analysisResult) {
		super(astModel, somoxConfiguration, analysisResult);
	}

    /* do only use this class if you are sure you want to create an NEW EventGroup
     * there are NO CHECKS */
	public EventGroup createEventGroup(final ConcreteClassifier implementingClass,
            final ConcreteClassifier interfaceClass, IComponentInterfaceStrategy interfaceStrategy) {
    	

    	 EventGroup eventgroup = RepositoryFactory.eINSTANCE.createEventGroup();
	
       	 eventgroup.setEntityName("JMSEventGroup" + egCounter);
       	 egCounter++;
         //eventgroup.setEntityName(this.naming.createInterfaceName(interfaceClass));
         // result.setDocumentation(KDMHelper.computeFullQualifiedName(interfaceClass));
       	 EventType eventType = RepositoryFactory.eINSTANCE.createEventType();
       	 eventType.setEntityName("myEventType");
       	 eventgroup.getEventTypes__EventGroup().add(eventType);
         //this.operationBuilder.createOperations(implementingClass, interfaceClass, operationInterface);
       	 this.analysisResult.getInternalArchitectureModel().getInterfaces__Repository().add(eventgroup);
       	 this.addAsExistingEventGroup(interfaceClass, eventgroup);
       	 
       	logger.info("creating EventGroup: interfaceClass: " + interfaceClass.getName()
       			+ " eventgroup: " + eventgroup.getEntityName() + " eventType: " + eventType.getEntityName());
	 
   	 return eventgroup;
    }
	
	// Source
    public void createSourcePort(final RepositoryComponent component, final EventGroup reqEventGroup, ComponentAndTypeNaming naming) {
        final SourceRole requiredRole = RepositoryFactory.eINSTANCE.createSourceRole();
        requiredRole.setEntityName(naming.createRequiredPortName(reqEventGroup, component));
        requiredRole.setEventGroup__SourceRole(reqEventGroup);
        component.getRequiredRoles_InterfaceRequiringEntity().add(requiredRole);
    }

    public ProvidedRole createSinkPort(final RepositoryComponent component, final EventGroup reqEventGroup, ComponentAndTypeNaming naming) {
        final SinkRole providedRole = RepositoryFactory.eINSTANCE.createSinkRole();
        providedRole.setEntityName(naming.createProvidedPortName(reqEventGroup, component));
        providedRole.setEventGroup__SinkRole(reqEventGroup);;
        component.getProvidedRoles_InterfaceProvidingEntity().add(providedRole);
        return providedRole;
    }
    
    // TODO dsg8fe mabye not needed because each access could be a separted Queue access...
    public boolean doesComponentAlreadyRequireEventGroup(final ConcreteClassifier accessedClass,
            final RepositoryComponent component) {
    	
    	if (accessedClass.getName().equals("MessageProducer")) {
    		
    	}
    	
       /* final OperationInterface reqInterface = (OperationInterface) this.createInterface(null, accessedClass);


        for (final RequiredRole role : component.getRequiredRoles_InterfaceRequiringEntity()) {

            if (role instanceof OperationRequsiredRole) {

                final OperationRequiredRole opReqRole = (OperationRequiredRole) role;
                final OperationInterface opInterface = opReqRole.getRequiredInterface__OperationRequiredRole();
                if (opInterface.equals(theInterface)) {
                    return true;
                }

            } else if (role instanceof SourceRole) {
            	// TODO dsg8fe thats not easy, because it make no sense to compare an eventgroup to the interface
            }else {
                InterfaceBuilder.logger.warn("Role type not yet supported: " + role.getClass().getSimpleName());
            }
        } */

        return false;
    }
    
    public boolean isJMSReceiverInterface(final ConcreteClassifier accessedClass) {
    	// if (accessedClass.equals(somoxConfiguration.getReprMessageConsumer())) {
    	if (accessedClass.getName().equals("MessageConsumer")) {
    		return true;
    	}else {
    		return false;
    	}
    }

    public boolean isJMSProducerInterface(final ConcreteClassifier accessedClass) { // TODO dsg8fe usage JMSDetection
    	//if (accessedClass.equals(somoxConfiguration.getReprMessageProducer())) {
    	if (accessedClass.getName().equals("MessageProducer")) {
    		EventRelElementsBuilder.logger.warn("MESSAGEPRODUCER");
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    public EventGroup getExistingEventGroup(final Type gastClass) {
    	EventGroup returnInterface = null;

        if (this.alreadyCreatedEvents.containsKey(gastClass)) {
            returnInterface = this.alreadyCreatedEvents.get(gastClass);
        }

        return returnInterface;
    }
    
    public void addAsExistingEventGroup(final Type gastClass, EventGroup eventgroup) {
    	this.alreadyCreatedEvents.put(gastClass, eventgroup);
    }
    
}
