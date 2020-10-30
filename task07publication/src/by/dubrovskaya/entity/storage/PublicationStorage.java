package by.dubrovskaya.entity.storage;

import by.dubrovskaya.entity.Publication;

import java.util.HashSet;
import java.util.Set;

public class PublicationStorage {
    private static final PublicationStorage INSTANCE = new PublicationStorage();

    private PublicationStorage() {
    }

    public static PublicationStorage getInstance() {
        return INSTANCE;
    }

    private Set<Publication> publications = new HashSet<>();

    public boolean add(Publication publication) {
        return publications.add(publication);
    }

    public boolean exists(Publication publication){
        return publications.contains(publication);
    }
    public void delete(Publication publication) {
        publications.remove(publication);
    }

    public Set<Publication> getPublications() {
        return publications;
    }
}
