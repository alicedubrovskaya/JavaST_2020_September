package testing;

import by.dubrovskaya.service.PublicationValidator;
import by.dubrovskaya.service.service.ValidatorService;
import by.dubrovskaya.service.service.implementation.ValidatorServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class ValidatorServiceTest {
    private ValidatorService validatorService = new ValidatorServiceImpl(new PublicationValidator());

    @DataProvider(name = "input_publication")
    public Object[][] createPublicationData() {
        return
                new Object[][]{
                        {new String[]{"An american tragedy", "300", "Boni & Liverigths", "Theodore Dreiser"}, true},
                        {new String[]{"Vogue", "20", "Conde Nast Publiations", "Anna Wintour"}, true},
                        {new String[]{"Vogue", "-20", "Conde Nast Publiations", "Anna Wintour"}, false}
                };
    }

    @DataProvider(name = "input_book")
    public Object[][] createBookData() {
        return
                new Object[][]{
                        {new String[]{"-1925", "novel"}, false},
                        {new String[]{"1925", "novel"}, true},
                        {new String[]{"1925", "Novel2"}, false}
                };
    }

    @DataProvider(name = "input_journal")
    public Object[][] createJournalData() {
        return
                new Object[][]{
                        {new String[]{"monthly", "1892"}, true},
                        {new String[]{"weekly", "2000"}, true},
                        {new String[]{"Weeklyy", "2000"}, false},
                        {new String[]{"weekly", "-200"}, false},
                        {new String[]{"weekly", "two"}, false}
                };
    }

    @Test(dataProvider = "input_publication")
    //TODO authors
    public void validateTest(String parameters[], boolean c) {
        Set<String> authors = new HashSet<>();
        authors.add(parameters[3]);
        boolean actual = validatorService.validate(parameters[0], parameters[1], parameters[2], authors);
        boolean expected = c;
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_book")
    public void validateBookTest(String parameters[], boolean expected) {
        boolean actual = validatorService.validateBook(parameters[0], parameters[1]);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_journal")
    public void validateJournal(String parameters[], boolean expected) {
        boolean actual = validatorService.validateJournal(parameters[0], parameters[1]);
        Assert.assertEquals(actual, expected);
    }
}
