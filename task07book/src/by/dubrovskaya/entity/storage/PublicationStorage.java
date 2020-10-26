package by.dubrovskaya.entity.storage;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;

import java.util.HashSet;
import java.util.Set;

public class PublicationStorage {
    private static final PublicationStorage instance = new PublicationStorage();
    private Set<Publication> publications = new HashSet<>();

    public boolean add(Publication publication) {
        return publications.add(publication);
    }

    public void delete(Publication publication) {
        publications.remove(publication);
    }

    public static PublicationStorage getInstance() {
        return instance;
    }

    public Set<Publication> getPublications() {
        return publications;
    }
}
