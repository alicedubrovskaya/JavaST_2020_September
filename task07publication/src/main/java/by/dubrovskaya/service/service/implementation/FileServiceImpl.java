package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.FileService;
import by.dubrovskaya.service.service.StringService;
import by.dubrovskaya.service.service.ValidatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an implementation of interface FileService
 */
public class FileServiceImpl implements FileService {
    private PublicationRepository publicationRepository;
    private StringService stringService;
    private ValidatorService validatorService;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FileServiceImpl(PublicationRepository publicationRepository, StringService stringService,
                           ValidatorService validatorService) {
        this.publicationRepository = publicationRepository;
        this.stringService = stringService;
        this.validatorService = validatorService;
    }

    /**
     * Gets set of publications from file
     *
     * @param filePath
     * @return set of read books
     */
    @Override
    public Set<Publication> getFromFile(String filePath) {
        Set<Publication> publications = new HashSet<>();
        logger.debug(String.format("Reading from file with path: %s", filePath));
        List<String> lines = publicationRepository.getFromFile(filePath);
        for (String line : lines) {
            Optional<Publication> publication = stringService.parse(line);
            if (publication.isPresent()) {
                publications.add(publication.get());
            }
        }
        return publications;
    }

    /**
     * Saves to file set of publications
     *
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
