package by.dubrovskaya.entity;

import java.util.Objects;
import java.util.Set;

/**
 * CLass describes entity Book. Has overridden methods, getters
 *
 * @author Alisa Dubrovskaya
 */
public class Book extends Publication {
    private int yearOfPublishing;
    private String genre;

    public Book(String title, int numberOfPages, String publishingHouse, Set<String> authors, int yearOfPublishing,
                String genre) {
        super(title, numberOfPages, publishingHouse, authors);
        this.yearOfPublishing = yearOfPublishing;
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfPublishing, genre);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Book other = (Book) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && super.equals(other)
                && Objects.equals(yearOfPublishing, other.getYearOfPublishing())
                && Objects.equals(genre, other.getGenre());
    }

    @Override
    public String toString() {
        return super.toString() +
                "[yearOfPublishing=" + yearOfPublishing +
                ",genre=" + genre +
                "]";
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String getGenre() {
        return genre;
    }
}
