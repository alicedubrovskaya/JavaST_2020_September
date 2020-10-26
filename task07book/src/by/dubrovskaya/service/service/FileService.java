package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Book;

import java.util.Set;

/**
 * Class is an interface, that is responsible for getting set of books and adding it to file
 */
public interface FileService  {
    Set<Book> getFromFile(String filePath);

    void saveToFile(Set<Book> books);
}
