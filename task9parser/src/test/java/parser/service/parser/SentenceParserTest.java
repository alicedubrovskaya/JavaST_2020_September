package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.ParagraphComposite;
import by.training.parser.service.parser.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private SentenceParser sentenceParser = SentenceParser.getINSTANCE();

    @Test(description = "Is testing parsing for sentences", dataProvider = "input_data")
    public void parseTest(String text, int expectedCountOfSentences) {
        Component component = new ParagraphComposite();
        sentenceParser.parse(text, component);
        int actual = component.getCountOfChildren();
        Assert.assertEquals(actual, expectedCountOfSentences);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"Part 1... Winter started early", 2},
                        {"Part 1.\tWinter started early. Was the weather fine?", 3},
                        {"\tPart 1.\tWinter started early. The weather was fine!", 3},
                        {"Part 1.    Winter started early.", 2},
                };
    }
}
