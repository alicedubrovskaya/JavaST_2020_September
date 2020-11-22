package by.training.parser.service.implementation;

import by.training.parser.dao.DaoFactory;
import by.training.parser.dao.FileDao;
import by.training.parser.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class is an implementation of interface FileService
 */
public class FileServiceImpl implements FileService {
    private FileDao fileDao = DaoFactory.getINSTANCE().getFileDao();

    /**
     * Reads from file
     *
     * @param filePath
     * @return text in string
     */
    @Override
    public String read(String filePath) {
        return fileDao.read(filePath);
    }
}
