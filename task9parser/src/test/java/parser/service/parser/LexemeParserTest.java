package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.SentenceComposite;
import by.training.parser.service.parser.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexemeParserTest {
    private LexemeParser lexemeParser = new LexemeParser();

    @Test(description = "Is testing parsing for lexemes", dataProvider = "input_data")
    public void parse(String text, int expectedCountOfLexemes) {
        Component component = new SentenceComposite();
        lexemeParser.parse(text, component);
        int actual = component.getCountOfChildren();
        Assert.assertEquals(actual, expectedCountOfLexemes);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"Part 1.\tWinter started early", 5},
                        {"My name is Frank...", 4},
                        {"Charlie - dog", 3},
                        {"Charlie-dog", 1},
                };
    }
}
