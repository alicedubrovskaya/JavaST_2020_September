package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.service.StringService;
import by.dubrovskaya.service.service.ValidatorService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringServiceImpl implements StringService {
    private ValidatorService validatorService;

    public StringServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
    public boolean startsWith(String phrase, String string) {
        Pattern pattern = Pattern.compile(String.format("^%s.*$", phrase));
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    @Override
    public boolean contains(String phrase, String string) {
        return string.contains(phrase);
    }

    @Override
    public Publication parse(String line) {
        Publication publication = null;
        if (line.matches("^book,.*$")) {
            line = line.replaceFirst("book,", "");
            publication = receiveBook(receiveParameters(line));
        } else if (line.matches("^journal,.*$")) {
            line = line.replaceFirst("journal,", "");
            publication = receiveJournal(receiveParameters(line));
        }
        return publication;
    }

    @Override
    public List<String> receiveParameters(String line) {
        String[] subLines = line.split(",");
        List<String> parameters = new ArrayList<>();
        for (String subLine : subLines) {
            parameters.add(subLine.substring(subLine.indexOf("=") + 1));
        }
        return parameters;
    }

    //TODO optional
    @Override
    public Publication receiveBook(List<String> parameters) {
        Publication publication = null;
        Set<String> authors = new HashSet<>();

        authors.add(parameters.get(3));
        //TODO authors =[[One], [Two]]

        if (parameters.size() == 6) {
            if (validatorService.validate(parameters.get(0), parameters.get(1), parameters.get(2), authors)) {
                publication = new Book(parameters.get(0), Integer.parseInt(parameters.get(1)),
                        parameters.get(2), authors, Integer.parseInt(parameters.get(4)), parameters.get(5));
            }
        }
        return publication;
    }

    @Override
    public Publication receiveJournal(List<String> parameters) {
        Publication publication = null;
        Set<String> authors = new HashSet<>();

        authors.add(parameters.get(3));
        //TODO authors =[[One], [Two]]

        if (parameters.size() == 6) {
            if (validatorService.validate(parameters.get(0), parameters.get(1), parameters.get(2), authors)) {
                publication = new Journal(parameters.get(0), Integer.parseInt(parameters.get(1)),
                        parameters.get(2), authors, parameters.get(4), Integer.parseInt(parameters.get(5)));
            }
        }
        return publication;
    }
}
