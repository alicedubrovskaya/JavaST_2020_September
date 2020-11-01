package testing.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.service.repository.PublicationRepositoryImpl;
import by.dubrovskaya.service.service.BookService;
import by.dubrovskaya.service.service.SearchService;
import by.dubrovskaya.service.service.implementation.BookServiceImpl;
import by.dubrovskaya.service.service.implementation.SearchServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.print.attribute.standard.JobKOctets;
import java.lang.reflect.Field;
import java.util.*;

public class SearchServiceTest {
    private BookService bookService = new BookServiceImpl(new PublicationRepositoryImpl());
    private SearchService searchService = new SearchServiceImpl(new PublicationRepositoryImpl());

    @DataProvider(name = "input_search")
    public Object[][] createData() {
        return
                new Object[][]{
                        {new Object[]{SearchType.ID, "id", "1"},
                                new HashSet<>(Arrays.asList(new Book("An american tragedy", 300, "Boni & Liverigths",
                                        new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel")))},
                };
    }

    @Test(dataProvider = "input_search")
    public void findByTagTest(Object[] parameters, Set<Publication> expected) {
        bookService.createNewPublications(expected);
        Map<String, Object> map = new HashMap<>();
        map.put((String) parameters[1], parameters[2]);
        Set<Publication> actual = searchService.findByTag((SearchType) parameters[0], map);
        Assert.assertEquals(actual, expected);
    }
}
