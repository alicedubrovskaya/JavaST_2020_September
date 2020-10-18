package by.training.entity;

public class Book {
    private String title;
    private int numberOfPages;
    private int yearOfPublishing;

    public Book(String title, int numberOfPages, int yearOfPublishing) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }
}
