package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.Matrix;

import java.util.Optional;


/**
 * Class is an interface, that is responsible for work with files
 */
public interface FileService {
    Optional<Matrix> getFromFile(String filePath);

    int[] getThreadsFromFile(String filePath);
}
