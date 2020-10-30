package by.dubrovskaya.service.service.implementation;

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
        String[] parameters = line.split(",");
        return receiveParameters(parameters);
    }

    //TODO optional
    @Override
    public Publication receiveParameters(String[] subLines) {
        Publication publication = null;
        List<String> parameters = new ArrayList<>();
        for (String subLine : subLines) {
            parameters.add(subLine.substring(subLine.indexOf("=") + 1));
        }

        Set<String> authors = new HashSet<>();
        authors.add(parameters.get(3));
        //TODO authors =[[One], [Two]]

        if (validatorService.validate(parameters.get(0), parameters.get(1), parameters.get(2), authors)) {
            publication = new Publication(parameters.get(0), Integer.parseInt(parameters.get(1)),
                    parameters.get(2), authors);
        }
        return publication;
    }
}
