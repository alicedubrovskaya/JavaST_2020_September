package by.dubrovskaya.service.query.sort.comparator;

import by.dubrovskaya.entity.Publication;

import java.util.Comparator;

public class PagesComparator implements Comparator<Publication> {
    @Override
    public int compare(Publication publication, Publication t1) {
        if (publication.getNumberOfPages() > t1.getNumberOfPages()) {
            return 1;
        } else if (publication.getNumberOfPages() < t1.getNumberOfPages()) {
            return -1;
        } else {
            return 0;
        }
    }
}
