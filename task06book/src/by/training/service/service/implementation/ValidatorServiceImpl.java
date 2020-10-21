package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.exception.InvalidBookException;
import by.training.exception.InvalidInvormationException;
import by.training.service.BookValidator;
import by.training.service.service.ValidatorService;

import java.util.Set;

public class ValidatorServiceImpl implements ValidatorService {

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
        if (!isValid) {
            throw new InvalidInvormationException();
        }
    }

    @Override
    public void validate(Set<String> authors) {
        BookValidator bookValidator = new BookValidator();
        if (!bookValidator.authorIsValid(authors)) {
            throw new InvalidBookException();
        }
    }
}
