package testing.service.observer;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.repository.PublicationRepositoryImpl;
import by.dubrovskaya.service.service.BookService;
import by.dubrovskaya.service.service.implementation.BookServiceImpl;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ObserverTest {
    private BookService bookService = new BookServiceImpl(new PublicationRepositoryImpl());
    private PublicationRepository publicationRepository = new PublicationRepositoryImpl();

    @Test
    public void test() {
        Publication publication = new Book("An american tragedy", 300, "Boni & Liverigths",
                new HashSet<>(Arrays.asList("Theodore Dreiser")), 1925, "novel");
        bookService.createNewPublication(publication);
        publicationRepository.update("An", 20, publication);

    }
}
