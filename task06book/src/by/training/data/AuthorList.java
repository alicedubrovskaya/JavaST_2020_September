package by.training.data;

import by.training.entity.Author;
import by.training.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorList {
    List<Author> authors = new ArrayList<>();

    public List<Author> getAuthorsOfBook(Book book){
        List<Author> authorsOfBook = new ArrayList<>();

        for (Author author: authors){
            if (author.wroteBook(book)){
                authorsOfBook.add(author);
            }
        }
        return authorsOfBook;
    }
}
