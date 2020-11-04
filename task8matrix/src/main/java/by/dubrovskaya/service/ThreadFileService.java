package by.dubrovskaya.service;

import by.dubrovskaya.entity.Matrix;

import java.util.Optional;

public interface ThreadFileService {
    Optional<Matrix> getFromFile(String filePath);
}
