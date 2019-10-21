package org.somox.analyzer.simplemodelanalyzer.builder;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
//import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;
import org.palladiosimulator.simulizar.indirection.composition.CompositionFactory;
import org.palladiosimulator.simulizar.indirection.composition.DataChannelSinkConnector;
import org.palladiosimulator.simulizar.indirection.composition.DataChannelSourceConnector;
import org.somox.analyzer.AnalysisResult;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.kdmhelper.metamodeladdition.Root;
import org.palladiosimulator.simulizar.indirection.system.DataChannel;

public class DataChannelConnectorBuilder extends AbstractBuilder{
	
	private static final Logger logger = Logger.getLogger(DataChannelConnectorBuilder.class);

	public DataChannelConnectorBuilder(Root astModel, SoMoXConfiguration somoxConfiguration,
			AnalysisResult analysisResult) {
		super(astModel, somoxConfiguration, analysisResult);
		// TODO Auto-generated constructor stub
	}

    public static Connector createDataChannelSinkConnector(final ComposedStructure parentComponent,
           final SinkRole providedRole, final RepositoryComponent requiredComponentInstance, 
           final RepositoryComponent providedComponentInstance, DataChannel dataChannel) {

    	final DataChannelSinkConnector newSinkConnector = CompositionFactory.eINSTANCE.createDataChannelSinkConnector();
    	parentComponent.getConnectors__ComposedStructure().add(newSinkConnector);;
    	newSinkConnector.setEntityName("DataChannel Connector from " + providedComponentInstance.getEntityName() + " to "
                + dataChannel.getEntityName());
    	
    	newSinkConnector.setDataChannel(dataChannel);
    	newSinkConnector.setSinkRole(providedRole);

        final AssemblyContext providingAssemblyContext = findAssemblyContext(parentComponent,
                providedComponentInstance);        
        newSinkConnector.setAssemblyContext(providingAssemblyContext);

        return newSinkConnector;
    }
    
    /* yes, yes, you could combine large parts of createDataChannelSinkConnector and createDataChannelSourceConnector 
     * and outsource them to a separate method, 
     * was not done here to make it more understandable */
    public static Connector createDataChannelSourceConnector(final ComposedStructure parentComponent,
            final SourceRole requiredRole, final RepositoryComponent requiredComponentInstance, 
            final RepositoryComponent providedComponentInstance, DataChannel dataChannel) {

    	final DataChannelSourceConnector newSourceConnector = CompositionFactory.eINSTANCE.createDataChannelSourceConnector();
    	parentComponent.getConnectors__ComposedStructure().add(newSourceConnector);;
    	newSourceConnector.setEntityName("DataChannel Connector from " + dataChannel.getEntityName() + " to "
                + providedComponentInstance.getEntityName());
    	
    	newSourceConnector.setDataChannel(dataChannel);
    	newSourceConnector.setSourceRole(requiredRole);

        final AssemblyContext requiredAssemblyContext = findAssemblyContext(parentComponent,
                providedComponentInstance);        
        newSourceConnector.setAssemblyContext(requiredAssemblyContext);

        return newSourceConnector;
    }

    
    private static AssemblyContext findAssemblyContext(final ComposedStructure parentComponent,
            final RepositoryComponent componentOfRole) {
        AssemblyContext resultSubcomponentInstance = null;
        boolean found = false;
        for (final AssemblyContext subcomponentInstance : parentComponent.getAssemblyContexts__ComposedStructure()) {

            if (subcomponentInstance.getEncapsulatedComponent__AssemblyContext().equals(componentOfRole)) {
                if (found) {
                    throw new IllegalArgumentException("Assumption on input model does not hold. "
                            + "Only one instance per component type per composite component assumed!");
                }
                resultSubcomponentInstance = subcomponentInstance;
                found = true;
            }
        }
        if (!found) {
            logger.warn("No subcomponent instance found for parent " + parentComponent.getEntityName()
                    + " and child component " + componentOfRole.getEntityName());
        }
        return resultSubcomponentInstance;

    }
}
