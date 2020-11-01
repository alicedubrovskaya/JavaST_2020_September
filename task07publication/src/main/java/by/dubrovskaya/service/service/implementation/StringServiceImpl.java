package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.service.service.StringService;
import by.dubrovskaya.service.service.ValidatorService;

import javax.swing.text.html.Option;
import java.util.*;
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
    public Optional<Publication> parse(String line) {
        Optional<Publication> publication = Optional.empty();

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
        List<String> authors = new ArrayList<>();
        String[] subLines = line.split(",");
        List<String> parameters = new ArrayList<>();

        for (String subLine : subLines) {
            if (subLine.indexOf("=") > 6 &&
                    subLine.substring(subLine.indexOf("=") - 7, subLine.indexOf("=")).equals("authors")) {
                authors = receiveAuthors(subLine.substring(subLine.indexOf("=") + 1));
            } else {
                parameters.add(subLine.substring(subLine.indexOf("=") + 1));
            }
        }
        //authors to the end
        parameters.addAll(authors);
        return parameters;
    }

    @Override
    public List<String> receiveAuthors(String string) {
        string = string.replaceAll("\\[", "");
        string = string.replaceAll("\\]", "");
        return Arrays.asList(string.split(";"));
    }

    @Override
    public Optional<Publication> receiveBook(List<String> parameters) {
        Publication publication = null;
        Set<String> authors = new HashSet<>();
        if (parameters.size() > 4) {
            for (int i = 5; i < parameters.size(); i++) {
                authors.add(parameters.get(i));
            }
        }

        if (parameters.size() > 5) {
            if (validatorService.validate(parameters.get(0), parameters.get(1), parameters.get(2), authors)
                    && validatorService.validateBook(parameters.get(3), parameters.get(4))) {
                publication = new Book(parameters.get(0), Integer.parseInt(parameters.get(1)),
                        parameters.get(2), authors, Integer.parseInt(parameters.get(3)), parameters.get(4));
            }
        }
        return Optional.ofNullable(publication);
    }

    @Override
    public Optional<Publication> receiveJournal(List<String> parameters) {
        Publication publication = null;
        Set<String> authors = new HashSet<>();
        if (parameters.size() > 4) {
            for (int i = 5; i < parameters.size(); i++) {
                authors.add(parameters.get(i));
            }
        }

        if (parameters.size() > 5) {
            if (validatorService.validate(parameters.get(0), parameters.get(1), parameters.get(2), authors) &&
                    validatorService.validateJournal(parameters.get(3), parameters.get(4))) {
                publication = new Journal(parameters.get(0), Integer.parseInt(parameters.get(1)),
                        parameters.get(2), authors, parameters.get(3), Integer.parseInt(parameters.get(4)));
            }
        }
        return Optional.ofNullable(publication);
    }
}
