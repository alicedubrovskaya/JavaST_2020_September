package by.training.serviсe.implementation;

import by.training.serviсe.ParserService;

import java.util.ArrayList;
import java.util.List;

public class RegexParserServiceImpl implements ParserService {
    //TODO another hierarchy
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

    @Override
    public char[][] parseStringToWords(char[] string) {
        return new char[0][];
    }

    @Override
    public char[] removeExtraCharacters(char[] string) {
        return new char[0];
    }
}
