package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.service.repository.BookRepository;
import by.training.service.service.FileService;

import java.util.Set;

public class FileServiceImpl implements FileService {
    private BookRepository bookRepository;

    public FileServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getFromFile(String filePath) {
        return bookRepository.getFromFile(filePath);
    }

    @Override
    public void saveToFile(Set<Book> books) {
        boolean firstBook = true;
        for (Book book : books) {
            bookRepository.saveToFile(book, firstBook);
            if (firstBook) {
                firstBook = false;
            }
        }
    }
}
