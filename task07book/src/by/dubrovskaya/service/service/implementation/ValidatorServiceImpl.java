package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.enumeration.BookInformation;
import by.dubrovskaya.exception.InvalidBookException;
import by.dubrovskaya.exception.InvalidInvormationException;
import by.dubrovskaya.service.BookValidator;
import by.dubrovskaya.service.service.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is a validator of data
 *
 * @author Alisa Dubrovskaya
 */
public class ValidatorServiceImpl implements ValidatorService {

    private static final Logger logger = LogManager.getLogger(ValidatorServiceImpl.class);

    /**
     * Validates all fields of a book
     *
     * @param book
     * @throws InvalidBookException
     */
    @Override
    public void validate(Book book) {
        BookValidator bookValidator = new BookValidator();
        try {
            if (!bookValidator.isValidBook(book)) {
                throw new InvalidBookException();
            }
        } catch (InvalidBookException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Validates information, depending on its type
     *
     * @param bookInformation
     * @param information
     */
    @Override
    public void validate(BookInformation bookInformation, String information) {
        BookValidator bookValidator = new BookValidator();
        boolean isValid = true;
        logger.debug("Validation of information depending on type of information");
        switch (bookInformation) {
            case TITLE:
                isValid = bookValidator.titleIsValid(information);
                break;
            case PUBLISHING_HOUSE:
                isValid = bookValidator.publishingHouseIsValid(information);
                break;
            case YEAR:
                isValid = bookValidator.yearIsValid(Integer.valueOf(information));
                break;
            case PAGES:
                isValid = bookValidator.pagesIsValid(Integer.valueOf(information));
                break;
        }
        logger.debug(String.format("Information is valid: %s", isValid));
        try {
            if (!isValid) {
                throw new InvalidInvormationException();
            }
        } catch (InvalidBookException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Validates set of authors
     *
     * @param authors
     */
    @Override
    public void validate(Set<String> authors) {
        BookValidator bookValidator = new BookValidator();
        logger.debug("Validation of authors");
        try {
            if (!bookValidator.authorIsValid(authors)) {
                throw new InvalidBookException();
            }
        } catch (InvalidBookException e) {
            logger.error(e.getMessage());
        }
    }
}
