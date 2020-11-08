package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.Matrix;

import java.util.Optional;

public interface FileService {
    Optional<Matrix> getFromFile(String filePath);

    int[] getThreadsFromFile(String filePath);
}
