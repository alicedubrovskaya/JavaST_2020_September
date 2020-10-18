package by.training.service;

import by.training.entity.Book;

public class BookValidator {
    //TODO more validation
    public boolean isValidBook(Book book) {
        return (book.getTitle() != null
                && book.getAuthors() != null
                && book.getNumberOfPages() > 0
                && book.getPublishingHouse() != null
                && book.getYearOfPublishing() > 0);
    }

}
