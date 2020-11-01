package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;

import java.util.Set;

/**
 * Class is an interface, that is responsible for getting set of books and adding it to file
 */
public interface FileService  {
    Set<Publication> getFromFile(String filePath);

    void saveToFile(Set<Publication> publications);
}
