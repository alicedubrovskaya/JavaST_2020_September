package by.dubrovskaya.service;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class is responsible for validation of data
 */
public class PublicationValidator {
    public boolean isValidPublication(Publication publication) {
        return (titleIsValid(publication.getTitle())
                && authorIsValid(publication.getAuthors())
                && publishingHouseIsValid(publication.getPublishingHouse())
                && pagesIsValid(publication.getNumberOfPages()));
    }

    public boolean isValidBook(Book book) {
        return yearIsValid(book.getYearOfPublishing()) && wordIsValid(book.getGenre());
    }

    public boolean isValidJournal(Journal journal) {
        return yearIsValid(journal.getFoundationDate()) && periodicityIsValid(journal.getPeriodicity());
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
     * Word consists of 1 or more letters in lower case
     *
     * @param word
     * @return
     */
    public boolean wordIsValid(String word) {
        return match(word, "^[a-z]+$");
    }

    public boolean periodicityIsValid(String periodicity) {
        return match(periodicity, "^[a-z]+$");
    }

    /**
     * Author name consists of two words starting with upper case letter
     *
     * @param authors
     * @return
     */
    public boolean authorIsValid(Set<String> authors) {
        for (String author : authors) {
            if (!match(author, "^[A-Z][a-z]*\\s[A-Z][a-z]*$")) {
                return false;
            }
        }
        return true;
    }

    public boolean yearIsValid(int year) {
        return (year > 0);
    }

    public boolean pagesIsValid(int pages) {
        return (pages > 0);
    }

    public boolean idIsValid(int id) {
        return (id > 0);
    }

    public boolean idIntervalIsValid(int  left, int right){
        return (left > 0 && right >=left);
    }
}
