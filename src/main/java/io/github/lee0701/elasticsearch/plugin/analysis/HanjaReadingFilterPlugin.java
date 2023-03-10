package io.github.lee0701.elasticsearch.plugin.analysis;

import io.github.lee0701.elasticsearch.index.analysis.HanjaReadingTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

public class HanjaReadingFilterPlugin extends Plugin implements AnalysisPlugin {
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return Collections.singletonMap("hanja_reading", HanjaReadingTokenFilterFactory::new);
    }
}
