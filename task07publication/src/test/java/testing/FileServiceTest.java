package testing;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.PublicationValidator;
import by.dubrovskaya.service.repository.PublicationRepositoryImpl;
import by.dubrovskaya.service.service.FileService;
import by.dubrovskaya.service.service.implementation.FileServiceImpl;
import by.dubrovskaya.service.service.implementation.StringServiceImpl;
import by.dubrovskaya.service.service.implementation.ValidatorServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileServiceTest {
    private FileService fileService = new FileServiceImpl(new PublicationRepositoryImpl(),
            new StringServiceImpl(new ValidatorServiceImpl(new PublicationValidator())),
            new ValidatorServiceImpl(new PublicationValidator()));

    @DataProvider(name = "input_data")
    public Object[][] createData() {
        return
                new Object[][]{
                        {new String[]{"task07publication/data/publication.txt"}, new HashSet<>(Arrays.asList(
                                new Journal("Vogue", 20, "Conde Nast Publiations",
                                        new HashSet<>(Arrays.asList("Anna Wintour")), "monthly", 1892),
                                new Book("An american tragedy", 300, "Boni & Liverigths",
                                        new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel")))
                        }
                };
    }

    @Test(dataProvider = "input_data")
    public void getFromFileTest(String[] parameters, Set<Publication> expected) {
        Set<Publication> actual = fileService.getFromFile(parameters[0]);
        Assert.assertEquals(actual, expected);
    }
}
