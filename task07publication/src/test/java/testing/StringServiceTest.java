package testing;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.PublicationValidator;
import by.dubrovskaya.service.service.StringService;
import by.dubrovskaya.service.service.implementation.StringServiceImpl;
import by.dubrovskaya.service.service.implementation.ValidatorServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringServiceTest {
    private StringService stringService = new StringServiceImpl(new ValidatorServiceImpl(new PublicationValidator()));

    @DataProvider(name = "input_phrase")
    public Object[][] createPhrases() {
        return
                new Object[][]{
                        {new String[]{"h", "holiday"}, true},
                        {new String[]{"1", "school"}, false},
                        {new String[]{"Hol", "Holiday"}, true}
                };
    }

    @DataProvider(name = "containing_phrase")
    public Object[][] createContainingPhrases() {
        return
                new Object[][]{
                        {new String[]{"h", "holiday"}, true},
                        {new String[]{"1", "school"}, false},
                        {new String[]{"school", "Holiday at school"}, true},
                        {new String[]{"sch", "Holiday at school"}, true}
                };
    }


    @DataProvider(name = "input_receive_book")
    public Object[][] createForReceivingBook() {
        return
                new Object[][]{
                        {new String[]{"An american tragedy", "300", "Boni & Liverigths", "1925", "novel", "Theodore Dreiser"},
                                new Book("An american tragedy", 300, "Boni & Liverigths",
                                        new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel")},
                };
    }

    @DataProvider(name = "input_receive_journal")
    public Object[][] createForReceivingJournal() {
        return
                new Object[][]{
                        {new String[]{"Vogue", "20", "Conde Nast Publiations", "monthly", "1892", "Anna Wintour"},
                                new Journal("Vogue", 20, "Conde Nast Publiations",
                                        new HashSet<>(Arrays.asList("Anna Wintour")), "monthly", 1892)},
                };
    }

    @DataProvider(name = "input_authors")
    public Object[][] createAuthorsString() {
        return
                new Object[][]{
                        {new String[]{"[Theodore Dreiser;Anna Wint]"}, new ArrayList<>(
                                Arrays.asList("Theodore Dreiser", "Anna Wint"))}
                };
    }

    @DataProvider(name = "input_line")
    public Object[][] createLine() {
        return
                new Object[][]{
                        {new String[]{
                                "title=An american tragedy,pages=300,house=Boni & Liverigths,authors=[Theodore Dreiser],year=1925,genre=novel"},
                                new ArrayList<>(Arrays.asList("An american tragedy", "300", "Boni & Liverigths", "1925", "novel", "Theodore Dreiser"))}
                };
    }

    @DataProvider(name = "input_full_line")
    public Object[][] createFullLine() {
        return
                new Object[][]{
                        {new String[]{
                                "book,title=An american tragedy,pages=300,house=Boni & Liverigths,authors=[Theodore Dreiser],year=1925,genre=novel"},
                                new Book("An american tragedy", 300, "Boni & Liverigths",
                                        new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel")}
                };
    }


    @Test(dataProvider = "input_phrase")
    public void startsWithTest(String[] parameters, boolean expected) {
        boolean actual = stringService.startsWith(parameters[0], parameters[1]);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "containing_phrase")
    public void containsTest(String[] parameters, boolean expected) {
        boolean actual = stringService.contains(parameters[0], parameters[1]);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_receive_book")
    public void receiveBookTest(String[] parameters, Book expected) {
        Publication actual = stringService.receiveBook(Arrays.asList(parameters));
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_receive_journal")
    public void receiveJournalTest(String[] parameters, Journal expected) {
        Publication actual = stringService.receiveJournal(Arrays.asList(parameters));
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_authors")
    public void receiveAuthorsTest(String[] parameters, List<String> expected) {
        List<String> actual = stringService.receiveAuthors(parameters[0]);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_line")
    public void receiveParametersTest(String[] parameters, List<String> expected) {
        List<String> actual = stringService.receiveParameters(parameters[0]);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "input_full_line")
    public void parseTest(String[] parameters, Publication expected) {
        Publication actual = stringService.parse(parameters[0]);
        Assert.assertEquals(actual,expected);
    }
}
