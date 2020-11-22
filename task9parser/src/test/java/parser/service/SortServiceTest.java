package parser.service;

import by.training.parser.entity.Composite;
import by.training.parser.service.ServiceFactory;
import by.training.parser.service.SortService;
import by.training.parser.service.TextService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortServiceTest {
    private SortService sortService = ServiceFactory.getINSTANCE().getSortService();
    private TextService textService = ServiceFactory.getINSTANCE().getTextService();

    @Test(description = "Testing sorting paragraphs by count of sentences", dataProvider = "input_data_paragraphs")
    public void sortParagraphsByCountOfSentencesTest(Composite text, String expected) {
        Composite actual = sortService.sortParagraphsByCountOfSentences(text);
        Assert.assertEquals(actual.recoverText(), expected);
    }

    @Test(description = "Testing sorting words in sentences by length", dataProvider = "input_data_sentences")
    public void sortWordsInSentencesByLengthTest(Composite text, String expected) {
        Composite actual = sortService.sortWordsInSentencesByLength(text);
        Assert.assertEquals(actual.recoverText(), expected);
    }

    @Test(description = "Testing sorting lexemes by occurrences of symbol and alphabet", dataProvider = "input_data_lexemes")
    public void sortLexemesByOccurrencesOfSymbolAndAlphabetTest(Composite text, String expected) {
        Composite actual = sortService.sortLexemesByOccurrencesOfSymbolAndAlphabet(text, 'a');
        Assert.assertEquals(actual.recoverText(), expected);
    }

    @DataProvider(name = "input_data_paragraphs")
    public Object[][] createData() {
        return
                new Object[][]{
                        {textService.parse("Winter was cold. It was snowing!\tDecember..."),
                                "December...\tWinter was cold. It was snowing!"},
                        {textService.parse("Winter was cold. It was snowing!\tDecember...\tJanuary?"),
                                "December...\tJanuary?\tWinter was cold. It was snowing!"},
                        {textService.parse("Winter. Snow! Cold...\tDecember..."),
                                "December...\tWinter. Snow! Cold..."},
                };
    }

    @DataProvider(name = "input_data_sentences")
    public Object[][] createDataSentences() {
        return
                new Object[][]{
                        {textService.parse("Winter was cold."), "was cold. Winter"},
                        {textService.parse("Dog Charlie"), "Dog Charlie"},
                        {textService.parse(""), ""},
                        {textService.parse("was cold."), "was cold."},
                };
    }

    @DataProvider(name = "input_data_lexemes")
    public Object[][] createDataTextWithLexemes() {
        return
                new Object[][]{
                        {textService.parse("alpha. beta gamma"), "alpha. gamma beta"},
                        {textService.parse("alph. betaa gamma"), "betaa gamma alph."},
                };
    }
}
