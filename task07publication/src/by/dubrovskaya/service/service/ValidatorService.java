package by.dubrovskaya.service.service;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;

import java.util.Map;
import java.util.Set;

/**
 * Class is an interface, that is responsible for validation
 */
public interface ValidatorService {
    void validate(Publication publication);

    void validate(PublicationInformation publicationInformation, Map<String, Object> information);

    void validate(Set<String> authors);
}
