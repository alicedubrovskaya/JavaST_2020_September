package by.training.serviсe.implementation;

import by.training.serviсe.StringWordService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class is an implementation of interface StringWordService.
 * This class does operations with words, which type is StringBuilder. Using Regular expressions
 *
 * @author Alisa Dubrovskaya
 */
public class RegexWordServiceImpl implements StringWordService {

    /**
     * Replaces specified letters of word with specified character
     * @param character
     * @param k
     * @param string
     * @return new word with replaced characters
     */
    @Override
    public StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(.{%d}).", k - 1);
        return new StringBuilder(word.replaceAll(regex, "$1" + character));
    }

    /**
     * Replaces character in specified sequences with needed character
     * @param preceding
     * @param incorrect
     * @param needed
     * @param string
     * @return new changed word
     */
    @Override
    public StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(%s)%s", preceding, incorrect);
        return new StringBuilder(word.replaceAll(regex, "$1" + needed));
    }

    /**
     * Replaces word with another word if it's length corresponds to needed length
     * @param length
     * @param word
     * @param wordToWrite
     * @return new word
     */
    @Override
    public StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite) {
        String regex = String.format("^.{%d}$", length);
        return new StringBuilder(word.toString().replaceAll(regex, wordToWrite.toString()));
    }

    /**
     * Checks if specified word starts with consonant or not
     * @param word
     * @return words starting with consonant
     */
    @Override
    public boolean startsWithConsonant(StringBuilder word) {
        Pattern pattern = Pattern.compile("[BСDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz].*");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    /**
     *  Parsers string of chars to array of words.
     *  The string is assumed to contain only words and spaces (single) between words
     *
     * @param string
     * @return list of words
     */
    @Override
    public List<StringBuilder> parseStringToWords(StringBuilder string) {
        List<StringBuilder> result = new ArrayList<>();

        String[] words = string.toString().split("\\s+");
        for (String word : words) {
            if (!"".equals(word)) {
                result.add(new StringBuilder(word));
            }
        }
        return result;
    }

    /**
     * Removes extra character from string. Leaves only letters (english, russian) and spaces
     * @param string
     * @return string without extra characters
     */
    @Override
    public StringBuilder removeExtraCharacters(StringBuilder string) {
        String word = string.toString();
        String regex = "[^a-zA-Zа-яА-я\\s]*";
        return new StringBuilder(word.replaceAll(regex, ""));
    }

}
