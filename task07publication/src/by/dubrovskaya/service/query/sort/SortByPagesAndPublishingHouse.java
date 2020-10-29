package by.dubrovskaya.service.query.sort;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.sort.comparator.PagesComparator;
import by.dubrovskaya.service.query.sort.comparator.PublishingHouseComparator;
import by.dubrovskaya.service.query.sort.comparator.TitleComparator;

import java.util.*;

public class SortByPagesAndPublishingHouse implements Query {
    private boolean isAscending;

    public SortByPagesAndPublishingHouse(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public Set<Publication> query(Set<Publication> publications) {
        Comparator<Publication> comparator = new PagesComparator().thenComparing(new PublishingHouseComparator());
        List<Publication> list = new LinkedList<Publication>(publications);
        if (!isAscending) {
            comparator = comparator.reversed();
        }
        list.sort(comparator);
        return new LinkedHashSet<>(list);
    }
}
