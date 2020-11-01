package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SortType;
import by.dubrovskaya.entity.enumeration.Sorting;

import java.util.Optional;
import java.util.Set;

/**
 * Class is an interface, that is responsible for sorting of books
 */
public interface SortService {
    Optional<Set<Publication>> sortByTag(SortType sortType, Sorting sorting);
}
