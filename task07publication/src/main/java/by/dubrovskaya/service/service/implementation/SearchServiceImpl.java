package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.search.*;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class is an implementation of interface FindBookService
 */
public class SearchServiceImpl implements SearchService {
    private PublicationRepository publicationRepository;
    private static final Logger logger = LogManager.getLogger(SearchServiceImpl.class);

    public SearchServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Finds books by tag (creates query, depending on type of tag)
     *
     * @param searchType
     * @param tagsInfo
     * @return found books
     */
    @Override
    public Set<Publication> findByTag(SearchType searchType, Map<String, Object> tagsInfo) {

        Set<Publication> publications = new HashSet<>();
        Query query = null;
        switch (searchType) {
            case TITLE:
                query = new SearchByTitleQuery((String) tagsInfo.get("title"));
                break;
            case YEAR:
                query = new SearchBooksByYearQuery((int) tagsInfo.get("year"));
                break;
            case PUBLISHING_HOUSE:
                query = new SearchByPublishingHouseQuery((String) tagsInfo.get("house"));
                break;
            case PAGES:
                query = new SearchByNumberOfPagesQuery((int) tagsInfo.get("pages"));
                break;
            case AUTHORS:
                query = new SearchByAuthorQuery((String) tagsInfo.get("author"));
                break;
            case ID:
                query = new SearchByIdQuery(Integer.parseInt((String) tagsInfo.get("id")));
                break;
            case PHRASE_AND_LETTER:
                query = new SearchByPhraseOrStartingLetter((String) tagsInfo.get("phrase"),
                        (Character) tagsInfo.get("letter"));
                break;
            case ID_INTERVAL:
                query = new SearchByIntervalOfId((int) tagsInfo.get("left"), (int) tagsInfo.get("right"));
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
