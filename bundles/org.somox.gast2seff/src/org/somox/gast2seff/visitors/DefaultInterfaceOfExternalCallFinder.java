package org.somox.gast2seff.visitors;

import org.apache.log4j.Logger;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.statements.Statement;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;
import org.somox.sourcecodedecorator.InterfaceSourceCodeLink;
import org.somox.sourcecodedecorator.MethodLevelSourceCodeLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

public class DefaultInterfaceOfExternalCallFinder implements InterfaceOfExternalCallFinding {

    private static final Logger logger = Logger.getLogger(DefaultInterfaceOfExternalCallFinder.class.getSimpleName());

    private final SourceCodeDecoratorRepository sourceCodeDecoratorRepository;
    private final BasicComponent basicComponent;

    public DefaultInterfaceOfExternalCallFinder(final SourceCodeDecoratorRepository sourceCodeDecoratorRepository,
            final BasicComponent basicComponent) {
        this.sourceCodeDecoratorRepository = sourceCodeDecoratorRepository;
        this.basicComponent = basicComponent;
    }

    /**
     * Query the interface port for the function access using the source code decorator.
     *
     * @param calledMethod
     *            The access to find in the PCM
     * @return interface port and operation for corresponding to the access.
     */
    @Override
    public InterfacePortOperationTuple getCalledInterfacePort(final Method calledMethod, Statement statement) { // GAST2SEFFCHANGE
        final InterfacePortOperationTuple interfacePortOperationTuple = new InterfacePortOperationTuple();
        final ConcreteClassifier accessedConcreteClassifier = calledMethod.getContainingConcreteClassifier();

        for (final RequiredRole requiredRole : this.getBasicComponent().getRequiredRoles_InterfaceRequiringEntity()) {
            Interface pcmInterface = this.getInterfaceFromRequiredRole(requiredRole);
            
            if (pcmInterface instanceof EventGroup && pcmInterface != null) { // TODO dsg8fe functional My heart breaks when I see my fucking stupid source code.
                logger.trace("accessed interface port " + requiredRole.getEntityName());
                logger.warn("Sussan, mit mehren Ports funktioniert das nicht mehr");
                interfacePortOperationTuple.role = requiredRole;
                interfacePortOperationTuple.signature = (Signature) ((EventGroup) pcmInterface).getEventTypes__EventGroup().get(0);
                return interfacePortOperationTuple;            	
            }
            
            /* TODO dsg8fe non of the condition is based on one of the parameter... what is the purpose of the whole construct? 
             * AND the existence of an interface ergo required role is checked with pcmInterface != null simply ... :( */
            for (final InterfaceSourceCodeLink ifLink : this.getSourceCodeDecoratorRepository()
                    .getInterfaceSourceCodeLink()) {
                if (pcmInterface != null && pcmInterface.equals(ifLink.getInterface())) {
                    final ConcreteClassifier gastClass = ifLink.getGastClass();
                    if (gastClass.equals(accessedConcreteClassifier)) {
                        logger.trace("accessed interface port " + requiredRole.getEntityName());
                        interfacePortOperationTuple.role = requiredRole;
                        // query operation:
                        interfacePortOperationTuple.signature = this.queryInterfaceOperation(calledMethod);
                        return interfacePortOperationTuple;
                    }
                }
            }
        }
        logger.warn("found no if port for " + accessedConcreteClassifier);
        return interfacePortOperationTuple;
    }
    
    @Override
    public InterfacePortOperationTuple getCalledSinkPort(final Method calledMethod, Statement statement) { // GAST2SEFFCHANGE
        final InterfacePortOperationTuple interfacePortOperationTuple = new InterfacePortOperationTuple();
        final ConcreteClassifier accessedConcreteClassifier = calledMethod.getContainingConcreteClassifier();

        for (final ProvidedRole providedRole : this.getBasicComponent().getProvidedRoles_InterfaceProvidingEntity()) {
            Interface pcmInterface = this.getInterfaceFromProvidedRole(providedRole);
            
            if (pcmInterface != null && pcmInterface instanceof EventGroup) { // TODO dsg8fe My heart breaks when I see my fucking stupid source code.
                logger.trace("accessed interface port " + providedRole.getEntityName());
                interfacePortOperationTuple.role = providedRole;
                interfacePortOperationTuple.signature = (Signature) ((EventGroup) pcmInterface).getEventTypes__EventGroup().get(0);
                return interfacePortOperationTuple;            	
            }
        }
        logger.warn("found no if port for " + accessedConcreteClassifier);
        return interfacePortOperationTuple;
    }
    
    protected SourceCodeDecoratorRepository getSourceCodeDecoratorRepository() {
        return sourceCodeDecoratorRepository;
    }
    
    protected BasicComponent getBasicComponent() {
        return basicComponent;
    }

    private Interface getInterfaceFromRequiredRole(RequiredRole requiredRole) {
        if (requiredRole instanceof OperationRequiredRole) {
            final OperationRequiredRole operReqRole = (OperationRequiredRole) requiredRole;
            return operReqRole.getRequiredInterface__OperationRequiredRole();
        } else if (requiredRole instanceof SourceRole) {
            final SourceRole sourceRole = (SourceRole) requiredRole;
            return sourceRole.getEventGroup__SourceRole();
        }
        return null;
    }
 
    private Interface getInterfaceFromProvidedRole(ProvidedRole providedRole) {
        if (providedRole instanceof OperationProvidedRole) {
            final OperationProvidedRole operProvRole = (OperationProvidedRole) providedRole;
            return operProvRole.getProvidedInterface__OperationProvidedRole();
        } else if (providedRole instanceof SinkRole) {
            final SinkRole sinkRole = (SinkRole) providedRole;
            return sinkRole.getEventGroup__SinkRole();
        }
        return null;
    }
    
    /**
     * Signature query
     *
     * @param invokedMethod
     *            The method invocation to find in the SAMM
     * @return Signature corresponding to function access
     */
    private Signature queryInterfaceOperation(final Method invokedMethod) { // GAST2SEFFCHANGE
        for (final MethodLevelSourceCodeLink methodLink : this.getSourceCodeDecoratorRepository()
                .getMethodLevelSourceCodeLink()) {

            final Member methodSourceCodeDecorator = methodLink.getFunction();
            if (methodSourceCodeDecorator.equals(invokedMethod)) { // GAST2SEFFCHANGE
                logger.trace("accessed operation " + methodLink.getOperation().getEntityName());
                return methodLink.getOperation();
            }
        }

        logger.warn("no accessed operation found for " + invokedMethod.getContainingConcreteClassifier() + "::"
                + invokedMethod.getName()); // GAST2SEFFCHANGE//GAST2SEFFCHANGE
        return null;
    }

}
