package by.training.dao;

import by.training.entity.Book;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookDaoImpl implements BookDao {

    @Override
    public Set<Book> readFromFile(String filePath) {
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
        } catch (IOException e) {
            System.err.println(e);
        }

        return books;
    }

    @Override
    public void writeToFile(Book book) {
        String absoluteFilePath = new File("task06book/data/result.txt").getAbsolutePath();
        try(FileWriter writer = new FileWriter(absoluteFilePath, false)){
            writer.write(book.toString());
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
