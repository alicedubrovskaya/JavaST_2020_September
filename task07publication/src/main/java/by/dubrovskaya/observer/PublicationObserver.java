package by.dubrovskaya.observer;

import by.dubrovskaya.entity.Publication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PublicationObserver implements Observer {
    private List<Publication> list = new ArrayList<>();
    private PagesInfo pagesInfo = PagesInfo.getINSTANCE();
    private static final Logger logger = LogManager.getLogger(PublicationObserver.class);

    public void addObservable(Publication publication) {
        logger.info("Adding of observable");
        list.add(publication);
        pagesInfo.add(publication.getNumberOfPages(), publication.getId());

    }

    public void removeObservable(Publication publication) {
        logger.info("Removing of observable");
        list.remove(publication);
        pagesInfo.remove(publication.getNumberOfPages(), publication.getId());
    }

    @Override
    public void update(Object object) {
        Publication publication = (Publication) object;
        pagesInfo.update(publication.getNumberOfPages(), publication.getId());
        logger.info("Updating");
    }
}
