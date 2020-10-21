package by.training.service.service;

import by.training.entity.Book;

import java.util.Set;

public interface FileService  {
    Set<Book> getFromFile(String filePath);

    void saveToFile(Set<Book> books);
}
