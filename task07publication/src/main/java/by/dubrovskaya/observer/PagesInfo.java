package by.dubrovskaya.observer;

import java.util.HashMap;
import java.util.Map;

public class PagesInfo {
    private static final PagesInfo INSTANCE = new PagesInfo();
    private Map<Integer, Integer> pages;

    /**
     * Map<K,V> where K-id, V-pages
     */
    private Map<Integer, Integer> pagesOfObject;

    private PagesInfo() {
        pages = new HashMap<>();
        pagesOfObject = new HashMap<>();
    }

    public void add(int countOfPages, int id) {
        if (pages.containsKey(countOfPages)) {
            pages.put(countOfPages, pages.get(countOfPages) + 1);
        } else {
            pages.put(countOfPages, 1);
        }
        pagesOfObject.put(id, countOfPages);
    }

    public void remove(int countOfPages, int id) {
        pages.put(countOfPages, pages.get(countOfPages) - 1);
        pagesOfObject.remove(id);
    }

    public void update(int currentCount, int id) {
        remove(pagesOfObject.get(id), id);
        add(currentCount, id);
    }

    public static PagesInfo getINSTANCE() {
        return INSTANCE;
    }
}
