package by.training.service.query;

import by.training.entity.Book;

import java.util.HashSet;
import java.util.Set;

public class SearchByTitleQuery implements Query {

    private String title;

    public SearchByTitleQuery(String title) {
        this.title=title;
    }

    @Override
    public Set<Book> query(Set<Book> books) {
        Set<Book> result = new HashSet<>();
        for (Book book: books){
            if (book.getTitle().equals(title)){
                result.add(book);
            }
        }
        return result;
    }
}
