package org.somox.analyzer.simplemodelanalyzer.builder;

import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.types.ClassifierReference;
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
import org.somox.analyzer.simplemodelanalyzer.detection.IComponentInterfaceStrategy;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.kdmhelper.KDMHelper;
import org.somox.kdmhelper.metamodeladdition.Root;

public class EventRelElementsBuilder extends AbstractBuilder {
	private int egCounter = 0;
	
    public EventRelElementsBuilder(Root astModel, SoMoXConfiguration somoxConfiguration, AnalysisResult analysisResult) {
		super(astModel, somoxConfiguration, analysisResult);
	}

    /* do only use this class if you are sure you want to create an NEW EventGroup
     * there are NO CHECKS */
	public EventGroup createEventGroup(final ConcreteClassifier implementingClass,
            final ConcreteClassifier interfaceClass, IComponentInterfaceStrategy interfaceStrategy) {
    	
    	// MessageConsumer and MessageProducer are different required interfaces in the source code, 
    	// but in the model they should be represented by one interface 
    	// and a prodvided role in one component and a required role in the other component.
    	 EventGroup eventgroup = RepositoryFactory.eINSTANCE.createEventGroup();
	
        /*enfor (final ClassifierReference inheritanceTypeAccess : KDMHelper
                .getInheritanceTypeAccesses(interfaceClass)) {
            final Classifier superType = inheritanceTypeAccess.getTarget();
            if (superType instanceof ConcreteClassifier) {
                if (this.somoxConfiguration.getClassifierFilter().passes((ConcreteClassifier) superType)
                        && interfaceStrategy.isComponentInterface((ConcreteClassifier) superType)) {
                    final Interface parentInterface = this.createEventGroup(implementingClass, (ConcreteClassifier) superType, interfaceStrategy);
                    //eventgroup.getParentInterfaces__Interface().add(parentInterface);
                }
            }
         }*/
       	 eventgroup.setEntityName("JMSEventGroup" + egCounter);
       	 egCounter++;
         //eventgroup.setEntityName(this.naming.createInterfaceName(interfaceClass));
         // result.setDocumentation(KDMHelper.computeFullQualifiedName(interfaceClass));
       	 EventType eventType = RepositoryFactory.eINSTANCE.createEventType();
       	 eventType.setEntityName("myEventType");
       	 eventgroup.getEventTypes__EventGroup().add(eventType);
         //this.operationBuilder.createOperations(implementingClass, interfaceClass, operationInterface);
       	 this.analysisResult.getInternalArchitectureModel().getInterfaces__Repository().add(eventgroup);
	 
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
    
    public boolean isJMSInterface(final ConcreteClassifier accessedClass) {
    	String nameAccessedClass = accessedClass.getClass().getName();
    	if (accessedClass.getName().equals("MessageProducer") | accessedClass.getName().equals("MessageConsumer")) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
