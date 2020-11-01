package by.dubrovskaya.observer;

import by.dubrovskaya.entity.Publication;

import java.util.ArrayList;
import java.util.List;

public class PublicationObserver implements Observer {
    private List<Publication> list = new ArrayList<>();
    private PagesInfo pagesInfo = PagesInfo.getINSTANCE();

    public void addObservable(Publication publication) {
        list.add(publication);
        pagesInfo.add(publication.getNumberOfPages(), publication.getId());
    }

    public void removeObservable(Publication publication) {
        list.remove(publication);
        pagesInfo.remove(publication.getNumberOfPages(), publication.getId());
    }

    @Override
    public void update(Object object) {
        Publication publication = (Publication) object;
        pagesInfo.update(publication.getNumberOfPages(), publication.getId());
    }
}
