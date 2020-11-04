package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;

import java.util.List;
import java.util.Optional;

public interface FileService {
    Optional<Matrix> getFromFile(String filePath);

    Optional<List<MatrixThread>> getThreadsFromFile(String filePath);
}
