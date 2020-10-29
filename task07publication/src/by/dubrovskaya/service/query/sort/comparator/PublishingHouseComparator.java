package by.dubrovskaya.service.query.sort.comparator;

import by.dubrovskaya.entity.Publication;

import java.util.Comparator;

public class PublishingHouseComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication publication, Publication t1) {
        return publication.getPublishingHouse().compareTo(t1.getPublishingHouse());
    }
}
