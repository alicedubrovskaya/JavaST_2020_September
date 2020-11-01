package by.dubrovskaya.service.query.search;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.ServiceFactory;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.service.StringService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Class is an implementation of interface Query.
 * Searches publications that start from specified letter or contain in title specified phrase
 */
public class SearchByPhraseOrStartingLetter implements Query {
    private StringService stringService;
    private String containingPhrase;
    private char startingLetter;

    public SearchByPhraseOrStartingLetter(String containingPhrase, char startingLetter) {
        this.containingPhrase = containingPhrase;
        this.startingLetter = startingLetter;
        this.stringService = ServiceFactory.getInstance().getStringService();
    }

    @Override
    public Optional<Set<Publication>> query(Set<Publication> publications) {
        Set<Publication> result = new HashSet<>();
        for (Publication publication : publications) {
            if (stringService.startsWith(String.valueOf(startingLetter), publication.getTitle())
                    || stringService.contains(containingPhrase, publication.getTitle())) {
                result.add(publication);
            }
        }
        return Optional.ofNullable(result);
    }
}
