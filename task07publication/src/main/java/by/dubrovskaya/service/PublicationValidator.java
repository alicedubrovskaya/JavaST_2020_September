package by.dubrovskaya.service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class is responsible for validation of data
 */
public class PublicationValidator {
    public boolean isValidPublication(String title, String numberOfPages, String publishingHouse, Set<String> authors) {
        return (titleIsValid(title)
                && authorIsValid(authors)
                && publishingHouseIsValid(publishingHouse)
                && pagesIsValid(numberOfPages));
    }

    public boolean isValidBook(String yearOfPublishing, String genre) {
        return yearIsValid(yearOfPublishing) && wordIsValid(genre);
    }

    public boolean isValidJournal(String foundationDate, String periodicity) {
        return yearIsValid(foundationDate) && periodicityIsValid(periodicity);
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

    public boolean yearIsValid(String year) {
        return year.matches("^\\d+$");
    }

    public boolean pagesIsValid(String pages) {
        return pages.matches("^\\d+$");
    }

    public boolean idIsValid(String id) {
        return id.matches("^\\d+$");
    }

    public boolean idIntervalIsValid(int left, int right) {
        return (left > 0 && right >= left);
    }
}
