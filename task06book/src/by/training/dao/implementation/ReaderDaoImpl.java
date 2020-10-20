package by.training.dao.implementation;

import by.training.dao.ReaderDao;
import by.training.entity.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public Set<Book> readFromFile(String filePath) throws IOException {
        String absoluteFilePath = new File(filePath).getAbsolutePath();
        Set<Book> books = new HashSet<>();

        String title = null;
        int numberOfPages = 0;
        int yearOfPublishing = 0;
        String publishingHouse = null;

        try (FileReader fr = new FileReader(absoluteFilePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("*")) {
                    Set<String> authors = new HashSet<>();
                    title = in.nextLine();
                    numberOfPages = Integer.valueOf(in.nextLine());
                    yearOfPublishing = Integer.valueOf(in.nextLine());
                    publishingHouse = in.nextLine();

                    int count = Integer.valueOf(in.nextLine());
                    for (int i = 0; i < count; i++) {
                        authors.add(in.nextLine());
                    }
                    books.add(new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        return books;
    }
}
