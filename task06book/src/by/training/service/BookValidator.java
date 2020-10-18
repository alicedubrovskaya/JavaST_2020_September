package by.training.service;

import by.training.entity.Book;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookValidator {
    public boolean isValidBook(Book book) {
        return (titleIsValid(book.getTitle())
                && authorIsValid(book.getAuthors())
                && publishingHouseIsValid(book.getPublishingHouse())
                && book.getNumberOfPages() > 0
                && book.getYearOfPublishing() > 0);
    }

    public boolean match(String input, String regex) {
        if (input != null) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            return matcher.matches();
        }
        return false;
    }

    /**
     * Title should start with UpperCase letter. And may consist of several words
     *
     * @param title
     * @return
     */
    public boolean titleIsValid(String title) {
        return match(title, "^[A-Z]([a-z]*\\s?)+$");
    }

    /**
     * Publishing house starts with upper case letter. And may consist of any symbols
     *
     * @param publishingHouse
     * @return
     */
    public boolean publishingHouseIsValid(String publishingHouse) {
        return match(publishingHouse, "^[A-Z].*$");
    }

    /**
     * Author name consists of two words starting with upper case letter
     *
     * @param authors
     * @return
     */
    public boolean authorIsValid(List<String> authors) {
        for (String author : authors) {
            if (!match(author, "^[A-Z][a-z]*\\s[A-Z][a-z]*$")) {
                return false;
            }
        }
        return true;
    }
}
