package by.training.dao.implementation;

import by.training.dao.ReaderDao;
import by.training.entity.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public Book readFromFile(String filePath) throws IOException {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        String title = null;
        int numberOfPages = 0;
        int yearOfPublishing = 0;
        String publishingHouse = null;
        List<String> authors = new ArrayList<>();

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            in.nextLine();
            title = in.nextLine();
            numberOfPages = Integer.valueOf(in.nextLine());
            yearOfPublishing = Integer.valueOf(in.nextLine());
            publishingHouse = in.nextLine();

            int count = Integer.valueOf(in.nextLine());
            for (int i = 0; i < count; i++) {
                authors.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        return new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
    }
}
