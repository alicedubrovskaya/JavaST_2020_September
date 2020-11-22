package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.TextComposite;
import by.training.parser.service.parser.ParagraphParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParagraphParserTest {
    //TODO instance
    private ParagraphParser paragraphParser = new ParagraphParser();

    @Test(description = "Is testing parsing for paragraphs", dataProvider = "input_data")
    public void parse(String text, int expectedCountOfParagraphs) {
        Component component = new TextComposite();
        paragraphParser.parse(text, component);
        int actual = component.getCountOfChildren();
        Assert.assertEquals(actual, expectedCountOfParagraphs);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"Part 1.\tWinter started early", 2},
                        {"Part 1.\tWinter started early.\n\tWas the weather fine?", 3},
                        {"\tPart 1.\tWinter started early.\n\tWas the weather fine?", 3},
                        {"Part 1.    Winter started early", 2},
                };
    }
}
