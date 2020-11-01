package by.dubrovskaya.entity;

import by.dubrovskaya.observer.Observable;
import by.dubrovskaya.observer.Observer;
import by.dubrovskaya.observer.PublicationObserver;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Publication implements Observable {
    private int id;
    private String title;
    private int numberOfPages;
    private Set<String> authors;
    private String publishingHouse;
    public PublicationObserver observer;

    public Publication(String title, int numberOfPages, String publishingHouse, Set<String> authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages, publishingHouse, authors);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Publication other = (Publication) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && Objects.equals(title, other.getTitle())
                && Objects.equals(numberOfPages, other.getNumberOfPages())
                && Objects.equals(publishingHouse, other.getPublishingHouse())
                && Objects.equals(authors, other.getAuthors());
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[title=" + title +
                ", number of pages=" + numberOfPages +
                ", authors=" + authors.toString() +
                "]";
    }

    public void changeData(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        this.observer = (PublicationObserver) observer;
        this.observer.addObservable(this);
    }

    @Override
    public void detach(Observer observer) {
        PublicationObserver publicationObserver = (PublicationObserver) observer;
        publicationObserver.removeObservable(this);
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getFirstAuthor() {
        return authors.stream().findFirst().get();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
