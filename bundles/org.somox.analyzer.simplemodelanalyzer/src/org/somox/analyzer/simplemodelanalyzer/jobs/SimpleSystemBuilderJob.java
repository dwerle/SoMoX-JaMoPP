package org.somox.analyzer.simplemodelanalyzer.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.simplemodelanalyzer.builder.ComponentBuilder;
import org.somox.analyzer.simplemodelanalyzer.builder.PCMSystemBuilder;
import org.somox.configuration.SoMoXConfiguration;
import org.somox.kdmhelper.metamodeladdition.Root;
import org.somox.ui.runconfig.SoMoXModelAnalyzerConfiguration;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

public class SimpleSystemBuilderJob implements IBlackboardInteractingJob<SoMoXBlackboard> {

    /** The SoMoX blackboard to interact with. */
    private SoMoXBlackboard blackboard;
    private SoMoXConfiguration somoxConfiguration;
    private Root root;
    
    public SimpleSystemBuilderJob(final SoMoXModelAnalyzerConfiguration config) throws CoreException {
        super();

        this.somoxConfiguration = config.getMoxConfiguration();

    }
    
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		final AnalysisResult analysisResult = this.blackboard.getAnalysisResult();
		
		this.root = analysisResult.getRoot();
        // Create PCM System
        final PCMSystemBuilder pcmSystemBuilder = new PCMSystemBuilder(root, somoxConfiguration, analysisResult,
                ComponentBuilder.getComponentBuilder(root, somoxConfiguration, analysisResult));
        pcmSystemBuilder.buildSystemModel();

        //analysisResult.setResultStatus(AnalysisResult.ResultStatus.SUCCESS);		
	}

	@Override
	public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "System Builder Job";
	}

	@Override
	public void setBlackboard(SoMoXBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}

}
