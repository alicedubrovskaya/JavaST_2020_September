package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface FileService
 */
public class FileServiceImpl implements FileService {
    private PublicationRepository publicationRepository;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FileServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Gets set of publications from file
     * @param filePath
     * @return set of read books
     */
    @Override
    public Set<Publication> getFromFile(String filePath) {
        logger.debug(String.format("Reading from file with path: %s", filePath));
        return publicationRepository.getFromFile(filePath);
    }

    /**
     * Saves to file set of publications
     * @param publications
     */
    @Override
    public void saveToFile(Set<Publication> publications) {
        logger.debug("Saving to file set of publications");
        boolean firstBook = true;
        for (Publication publication : publications) {
            logger.debug(String.format("Saving to file publication: %s", publication.toString()));
            publicationRepository.saveToFile(publication, firstBook);
            if (firstBook) {
                firstBook = false;
            }
        }
    }
}
