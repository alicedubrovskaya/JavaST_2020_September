package by.dubrovskaya.service.query.sort.comparator;

import by.dubrovskaya.entity.Publication;

import java.util.Comparator;

public class AuthorsComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication publication, Publication t1) {
        String firstAuthor = publication.getFirstAuthor();
        String secondAuthor = t1.getFirstAuthor();
        return firstAuthor.compareTo(secondAuthor);
    }
}
