package io.github.lee0701.elasticsearch.index.analysis;

import io.github.lee0701.hanjareading.HanjaReadingApi;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class HanjaReadingTokenFilter extends TokenFilter {

    private final HanjaReadingApi api = new HanjaReadingApi("http://hanja-reading:3000");
    private final CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);

    public HanjaReadingTokenFilter(TokenStream input) {
        super(input);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if(input.incrementToken()) {
            final char[] term = charTermAttribute.buffer();
            final String termStr = new String(term).trim();
            String reading = api.request(termStr, "{r}");
            if(reading != null) {
                charTermAttribute.setEmpty().append(reading);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() throws IOException {
        super.reset();
    }
}
