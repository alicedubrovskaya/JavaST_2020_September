package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.service.service.StringService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringServiceImpl implements StringService {

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
}
