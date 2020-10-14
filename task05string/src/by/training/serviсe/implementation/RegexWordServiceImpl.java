package by.training.serviсe.implementation;

import by.training.serviсe.StringWordService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWordServiceImpl implements StringWordService {

    @Override
    public StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(.{%d}).", k - 1);
        return new StringBuilder(word.replaceAll(regex, "$1" + character));
    }

    @Override
    public StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(%s)%s", preceding, incorrect);
        return new StringBuilder(word.replaceAll(regex, "$1" + needed));
    }

    @Override
    public StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite) {
        String regex = String.format("^.{%d}$", length);
        return new StringBuilder(word.toString().replaceAll(regex, wordToWrite.toString()));
    }

    @Override
    public boolean startsWithConsonant(StringBuilder word) {
        Pattern pattern = Pattern.compile("[BСDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz].*");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    @Override
    public List<StringBuilder> parseStringToWords(StringBuilder string) {
        List<StringBuilder> result = new ArrayList<>();

        //TODO spaces
        String[] words = string.toString().split("\\s+");
        for (String word : words) {
            if (!"".equals(word)) {
                result.add(new StringBuilder(word));
            }
        }
        return result;
    }

    @Override
    public StringBuilder removeExtraCharacters(StringBuilder string) {
        String word = string.toString();
        String regex = "[^a-zA-Zа-яА-я\\s]*";
        return new StringBuilder(word.replaceAll(regex, ""));
    }

}
