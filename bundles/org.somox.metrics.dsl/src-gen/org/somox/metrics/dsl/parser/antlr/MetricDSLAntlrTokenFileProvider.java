/*
* generated by Xtext
*/
package org.somox.metrics.dsl.parser.antlr;

import java.io.InputStream;

import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MetricDSLAntlrTokenFileProvider implements IAntlrTokenFileProvider {

    @Override
    public InputStream getAntlrTokenFile() {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResourceAsStream("org/somox/metrics/dsl/parser/antlr/internal/InternalMetricDSL.tokens");
    }
}
