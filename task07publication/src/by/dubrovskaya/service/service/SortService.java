package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;
import by.dubrovskaya.entity.enumeration.Sorting;

import java.util.Set;

/**
 * Class is an interface, that is responsible for sorting of books
 */
public interface SortService {
    Set<Publication> sortByTag(PublicationInformation publicationInformation, Sorting sorting);
}
