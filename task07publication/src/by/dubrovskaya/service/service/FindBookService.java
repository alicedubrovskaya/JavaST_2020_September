package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;

import java.util.Set;

/**
 * Class is an interface, that is responsible for finding of books
 */
public interface FindBookService {
    Set<Publication> findByTag(PublicationInformation publicationInformation, String tag);
}
