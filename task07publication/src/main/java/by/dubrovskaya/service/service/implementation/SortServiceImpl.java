package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SortType;
import by.dubrovskaya.entity.enumeration.Sorting;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.sort.*;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an implementation of interface SortBookService
 */
public class SortServiceImpl implements SortService {
    private PublicationRepository publicationRepository;
    private static final Logger logger = LogManager.getLogger(SortServiceImpl.class);

    public SortServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Sorts books by tag (creates query, depending on type of tag)
     *
     * @param sortType
     * @param sorting
     * @return
     */
    @Override
    public Optional<Set<Publication>> sortByTag(SortType sortType, Sorting sorting) {
        Optional<Set<Publication>> publications = Optional.empty();
        Query query = null;
        boolean isAscending = Sorting.getEnum("asc").equals(sorting);
        switch (sortType) {
            case TITLE:
                query = new SortByTitleQuery(isAscending);
                break;
            case PUBLISHING_HOUSE:
                query = new SortByPublishingHouseQuery(isAscending);
                break;
            case PAGES:
                query = new SortByPagesQuery(isAscending);
                break;
            case AUTHORS:
                query = new SortByAuthorQuery(isAscending);
                break;
            case TITLE_AND_PAGE:
                query = new SortByTitleAndPages(isAscending);
                break;
            case PAGE_AND_PUBLISHING_HOUSE:
                query = new SortByPagesAndPublishingHouse(isAscending);
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
