package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.search.*;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.FindBookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface FindBookService
 */
public class FindBookServiceImpl implements FindBookService {
    private PublicationRepository publicationRepository;
    private static final Logger logger = LogManager.getLogger(FindBookServiceImpl.class);

    public FindBookServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Finds books by tag (creates query, depending on type of tag)
     *
     * @param publicationInformation
     * @param tag
     * @return found books
     */
    @Override
    public Set<Publication> findByTag(PublicationInformation publicationInformation, String tag) {
        Set<Publication> publications = new HashSet<>();
        Query query = null;
        switch (publicationInformation) {
            case TITLE:
                query = new SearchByTitleQuery(tag);
                break;
            case YEAR:
                query = new SearchByYearQuery(Integer.valueOf(tag));
                break;
            case PUBLISHING_HOUSE:
                query = new SearchByPublishingHouseQuery(tag);
                break;
            case PAGES:
                query = new SearchByNumberOfPagesQuery(Integer.valueOf(tag));
                break;
            case AUTHORS:
                query = new SearchByAuthorQuery(tag);
                break;
            default:
        }

        logger.debug("Interface query implemented");
        try {
            publications = publicationRepository.query(query);
        } catch (BooksNotFoundException e) {
            logger.error(e.getMessage());
        }
        return publications;
    }
}
