package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.LexemeComposite;
import by.training.parser.service.parser.WordAndPunctuationParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordAndPunctuationParserTest {
    private WordAndPunctuationParser wordAndPunctuationParser = new WordAndPunctuationParser();

    @Test(description = "Is testing parsing for lexemes", dataProvider = "input_data")
    public void parse(String text, int expectedCountOfWordsAndPunctuation) {
        Component component = new LexemeComposite();
        wordAndPunctuationParser.parse(text, component);
        int actual = component.getCountOfChildren();
        Assert.assertEquals(actual, expectedCountOfWordsAndPunctuation);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"Part1.", 2},
                        {"My Frank...", 3},
                        {"Charlie-dog", 1},
                        {"Dog...", 2},
                };
    }
}
