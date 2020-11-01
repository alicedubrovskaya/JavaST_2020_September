package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.exception.InvalidPublicationException;
import by.dubrovskaya.exception.InvalidInvormationException;
import by.dubrovskaya.service.PublicationValidator;
import by.dubrovskaya.service.service.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * Class is a validator of data
 *
 * @author Alisa Dubrovskaya
 */
public class ValidatorServiceImpl implements ValidatorService {

    private static final Logger logger = LogManager.getLogger(ValidatorServiceImpl.class);
    private PublicationValidator publicationValidator;

    public ValidatorServiceImpl(PublicationValidator publicationValidator) {
        this.publicationValidator = publicationValidator;
    }

    /**
     * Validates all parameters of publication
     *
     * @param title
     * @param numberOfPages
     * @param publishingHouse
     * @param authors
     * @return
     */
    @Override
    public boolean validate(String title, String numberOfPages, String publishingHouse, Set<String> authors) {
        boolean isValid = true;
        try {
            if (!publicationValidator.isValidPublication(title, numberOfPages, publishingHouse, authors)) {
                isValid = false;
                throw new InvalidPublicationException();
            }
        } catch (InvalidPublicationException e) {
            logger.error(e.getMessage());
        }
        return isValid;
    }

    @Override
    public boolean validateBook(String yearOfPublishing, String genre) {
        boolean isValid = true;
        try {
            if (!publicationValidator.isValidBook(yearOfPublishing, genre)) {
                isValid = false;
                throw new InvalidPublicationException();
            }
        } catch (InvalidPublicationException e) {
            logger.error(e.getMessage());
        }
        return isValid;
    }

    @Override
    public boolean validateJournal(String periodicity, String foundationDate) {
        boolean isValid = true;
        try {
            if (!publicationValidator.isValidJournal(periodicity, foundationDate)) {
                isValid = false;
                throw new InvalidPublicationException();
            }
        } catch (InvalidPublicationException e) {
            logger.error(e.getMessage());
        }
        return isValid;
    }

    /**
     * Validates information, depending on its type
     *
     * @param searchType
     * @param information
     */
    @Override
    public void validate(SearchType searchType, Map<String, Object> information) {
        boolean isValid = true;
        logger.debug("Validation of information depending on type of information");
        switch (searchType) {
            case TITLE:
                isValid = publicationValidator.titleIsValid((String) information.get("title"));
                break;
            case PUBLISHING_HOUSE:
                isValid = publicationValidator.publishingHouseIsValid((String) information.get("house"));
                break;
            case YEAR:
                isValid = publicationValidator.yearIsValid((String) information.get("year"));
                break;
            case PAGES:
                isValid = publicationValidator.pagesIsValid((String) information.get("pages"));
                break;
            case ID:
                isValid = publicationValidator.idIsValid((String) information.get("id"));
                break;
            case PHRASE_AND_LETTER:
                //TODO char
                isValid = publicationValidator.wordIsValid((String) information.get("phrase"))
                        && publicationValidator.wordIsValid((String) information.get("letter"));
                break;
            case ID_INTERVAL:
                isValid = publicationValidator.idIntervalIsValid(
                        (int) information.get("left"), (int) information.get("right"));
                break;
        }
        logger.debug(String.format("Information is valid: %s", isValid));
        try {
            if (!isValid) {
                throw new InvalidInvormationException();
            }
        } catch (InvalidPublicationException e) {
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
        logger.debug("Validation of authors");
        try {
            if (!publicationValidator.authorIsValid(authors)) {
                throw new InvalidPublicationException();
            }
        } catch (InvalidPublicationException e) {
            logger.error(e.getMessage());
        }
    }
}
