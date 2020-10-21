package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.exception.InvalidBookException;
import by.training.exception.InvalidInvormationException;
import by.training.service.BookValidator;
import by.training.service.service.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ValidatorServiceImpl implements ValidatorService {

    private static final Logger logger = LogManager.getLogger(ValidatorServiceImpl.class);

    @Override
    public void validate(Book book) throws InvalidBookException {
        BookValidator bookValidator = new BookValidator();
        //TODO catching
        if (!bookValidator.isValidBook(book)) {
            throw new InvalidBookException();
        }
    }

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
        if (!isValid) {
            throw new InvalidInvormationException();
        }
    }

    @Override
    public void validate(Set<String> authors) {
        BookValidator bookValidator = new BookValidator();
        logger.debug("Validation of authors");
        if (!bookValidator.authorIsValid(authors)) {
            throw new InvalidBookException();
        }
    }
}
