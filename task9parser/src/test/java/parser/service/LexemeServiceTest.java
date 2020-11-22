package parser.service;

import by.training.parser.entity.Component;
import by.training.parser.service.LexemeService;
import by.training.parser.service.ServiceFactory;
import by.training.parser.service.TextService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexemeServiceTest {
    private LexemeService lexemeService = ServiceFactory.getINSTANCE().getLexemeService();
    private TextService textService = ServiceFactory.getINSTANCE().getTextService();

    @Test(description = "Testing calculation of symbol occurrences in lexeme", dataProvider = "input_data")
    public void numberOfSymbolOccurrencesTest(Component lexeme, long expected) {
        long actual = lexemeService.numberOfSymbolOccurrences(lexeme, 'l');
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {textService.parse("hello..."), 2},
                        {textService.parse("Level20"), 1},
                        {textService.parse("123"), 0}
                };
    }
}
