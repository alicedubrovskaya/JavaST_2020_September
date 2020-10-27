package by.dubrovskaya.entity;

import java.util.Objects;
import java.util.Set;

public class Journal extends Publication {
    private String periodicity;
    //TODO Data?
    private int foundationDate;

    public Journal(String title, int numberOfPages, String publishingHouse, Set<String> authors, String periodicity,
                   int foundationDate) {
        super(title, numberOfPages, publishingHouse, authors);
        this.periodicity = periodicity;
        this.foundationDate = foundationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), periodicity, foundationDate);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        Journal other = (Journal) otherObject;
        return otherObject != null
                && getClass() == otherObject.getClass()
                && super.equals(other)
                && Objects.equals(periodicity, other.getPeriodicity())
                && Objects.equals(foundationDate, other.getFoundationDate());
    }


    @Override
    public String toString() {
        return super.toString() +
                "[periodicity=" + periodicity +
                ",foundationDate=" + foundationDate +
                "]";
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public int getFoundationDate() {
        return foundationDate;
    }
}
