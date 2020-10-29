package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.exception.InvalidBookException;
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

    /**
     * Validates all fields of publication
     *
     * @param publication
     * @throws InvalidBookException
     */
    @Override
    public void validate(Publication publication) {
        PublicationValidator publicationValidator = new PublicationValidator();
        try {
            if (!(publicationValidator.isValidPublication(publication) &&
                    ((publication.getClass() == Book.class && publicationValidator.isValidBook((Book) publication))
                            || (publication.getClass() == Journal.class && publicationValidator.isValidJournal((Journal) publication))))) {
                throw new InvalidBookException();
            }
        } catch (InvalidBookException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Validates information, depending on its type
     *
     * @param searchType
     * @param information
     */
    @Override
    public void validate(SearchType searchType, Map<String, Object> information) {
        PublicationValidator publicationValidator = new PublicationValidator();
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
                isValid = publicationValidator.yearIsValid((int) information.get("year"));
                break;
            case PAGES:
                isValid = publicationValidator.pagesIsValid((int) information.get("pages"));
                break;
            case ID:
                isValid = publicationValidator.idIsValid((int) information.get("id"));
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
        PublicationValidator publicationValidator = new PublicationValidator();
        logger.debug("Validation of authors");
        try {
            if (!publicationValidator.authorIsValid(authors)) {
                throw new InvalidBookException();
            }
        } catch (InvalidBookException e) {
            logger.error(e.getMessage());
        }
    }
}
