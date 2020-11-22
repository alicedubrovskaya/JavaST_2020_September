package parser.service.parser;

import by.training.parser.entity.Component;
import by.training.parser.entity.PunctuationMarkComposite;
import by.training.parser.service.parser.SymbolParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SymbolParserTest {
    private SymbolParser symbolParser = new SymbolParser();

    @Test(description = "Is testing parsing for symbols", dataProvider = "input_data")
    public void parse(String text, int expectedCountOfSymbols) {
        Component component = new PunctuationMarkComposite();
        symbolParser.parse(text, component);
        int actual = component.getCountOfChildren();
        Assert.assertEquals(actual, expectedCountOfSymbols);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {"Part1.", 6},
                        {"My Frank...", 10},
                        {"\tCharlie - dog", 11},
                        {"Dog...", 6},
                };
    }
}
