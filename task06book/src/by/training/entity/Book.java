package by.training.entity;

import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private int numberOfPages;
    private int yearOfPublishing;
    private List<String> authors;
    private String publishingHouse;

    public Book(String title, int numberOfPages, int yearOfPublishing, String publishingHouse, List<String> authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfPublishing = yearOfPublishing;
        this.publishingHouse = publishingHouse;
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Book other = (Book) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Objects.equals(title, other.getTitle())
                && Objects.equals(numberOfPages, other.getNumberOfPages())
                && Objects.equals(yearOfPublishing, other.getYearOfPublishing())
                && Objects.equals(publishingHouse, other.getPublishingHouse())
                && Objects.equals(authors, other.getAuthors());
    }

    @Override
    public String toString() {
        return "Book[title=" + title +
                ", number of pages=" + numberOfPages +
                ", year of publishing=" + yearOfPublishing +
                ", authors=" + authors.toString() + "]";
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

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }
}