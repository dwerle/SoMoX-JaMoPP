package org.somox.analyzer.simplemodelanalyzer.jobs;

import org.somox.analyzer.AnalysisResult;
import org.somox.configuration.SoMoXConfiguration;

import de.uka.ipd.sdq.workflow.blackboard.Blackboard;

/**
 * Blackboard to transfer SoMoX analysis results between jobs of the overall SoMoX run.
 *
 * @author Oliver Burkhardt
 * @author Benjamin Klatt
 *
 */
public class SoMoXBlackboard extends Blackboard<Object> {

    /** The result to hand over between jobs. */
    private AnalysisResult analysisResult = null;
    
    private SoMoXConfiguration config = null;

    /**
     * Get the analysis result.
     *
     * @return the analysisResult
     */
    public AnalysisResult getAnalysisResult() {
        return this.analysisResult;
    }

    /**
     * Set the analysis result.
     *
     * @param analysisResult
     *            the analysisResult to set
     */
    public void setAnalysisResult(final AnalysisResult analysisResult) {
        this.analysisResult = analysisResult;
    }

	public SoMoXConfiguration getConfig() {
		return config;
	}

	public void setConfig(SoMoXConfiguration config) {
		this.config = config;
	}

}
