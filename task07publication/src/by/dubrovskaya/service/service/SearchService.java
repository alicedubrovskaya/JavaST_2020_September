package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;

import java.util.Map;
import java.util.Set;

/**
 * Class is an interface, that is responsible for publications finding
 */
public interface SearchService {
    Set<Publication> findByTag(PublicationInformation publicationInformation, Map<String, Object> tagsInfo);
}
