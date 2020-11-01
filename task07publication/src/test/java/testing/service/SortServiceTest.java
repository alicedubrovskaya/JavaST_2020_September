package testing.service;

import by.dubrovskaya.controller.PublicationController;
import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SortType;
import by.dubrovskaya.entity.enumeration.Sorting;
import by.dubrovskaya.service.repository.PublicationRepositoryImpl;
import by.dubrovskaya.service.service.BookService;
import by.dubrovskaya.service.service.SearchService;
import by.dubrovskaya.service.service.SortService;
import by.dubrovskaya.service.service.implementation.BookServiceImpl;
import by.dubrovskaya.service.service.implementation.SearchServiceImpl;
import by.dubrovskaya.service.service.implementation.SortServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortServiceTest {
    private SortService sortService = new SortServiceImpl(new PublicationRepositoryImpl());
    private BookService bookService = new BookServiceImpl(new PublicationRepositoryImpl());

    @DataProvider(name = "input_sort")
    public Object[][] createData() {
        return
                new Object[][]{
                        {new Object[]{SortType.TITLE, Sorting.ASCENDING},
                                new HashSet<>(Arrays.asList(
                                        new Book("An american tragedy", 300, "Boni & Liverigths",
                                                new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel"),
                                        new Journal("Vogue", 20, "Conde Nast Publiations",
                                                new HashSet<>(Arrays.asList("Anna Wintour")), "monthly", 1892)))},
                };
    }

    @Test(dataProvider = "input_sort")
    public void sortByTagTest(Object[] parameters, Set<Publication> expected) {
        bookService.createNewPublications(expected);
        Set<Publication> actual = sortService.sortByTag((SortType) parameters[0], (Sorting) parameters[1]);
        Assert.assertEquals(actual, expected);
    }
}
