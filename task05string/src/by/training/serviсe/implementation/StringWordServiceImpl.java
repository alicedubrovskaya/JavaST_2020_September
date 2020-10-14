package by.training.serviсe.implementation;

import by.training.serviсe.StringWordService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is an implementation of interface StringWordService.
 * This class does operations with words, which type is StringBuilder.
 *
 * @author Alisa Dubrovskaya
 */
public class StringWordServiceImpl implements StringWordService {
    //TODO upperCase
    private static final char[] englishConsonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
            'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] russianConsonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р',
            'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

    /**
     * Replaces specified letters of word with specified character
     * @param character
     * @param k
     * @param word
     * @return new word with replaced characters
     */
    @Override
    public StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder word) {
        StringBuilder result = new StringBuilder();
        int positionForK = 0;

        for (int i = 0; i < word.length(); i++) {
            positionForK++;
            if (positionForK == k) {
                result.append(character);
                positionForK = 0;
            } else {
                result.append(word.charAt(i));
            }
        }

        return result;
    }

    /**
     * Replaces character in specified sequences with needed character
     * @param preceding
     * @param incorrect
     * @param needed
     * @param word
     * @return new changed word
     */
    @Override
    public StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder word) {
        StringBuilder resultingString = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && word.charAt(i - 1) == preceding && word.charAt(i) == incorrect) {
                resultingString.append(needed);
            } else {
                resultingString.append(word.charAt(i));
            }
        }
        return resultingString;
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
        StringBuilder result;
        if (length == word.length()) {
            result = new StringBuilder(wordToWrite);
        } else {
            result = new StringBuilder(word);
        }
        return result;
    }

    /**
     * Checks if specified word starts with consonant or not
     * @param word
     * @return words starting with consonant
     */
    @Override
    public boolean startsWithConsonant(StringBuilder word) {
        boolean hasConsonant = false;
        char firstCharacter = word.charAt(0);

        if (isEnglishLetter(firstCharacter)) {
            for (int i = 0; i < englishConsonants.length; i++) {
                if (englishConsonants[i] == firstCharacter) {
                    hasConsonant = true;
                }
            }
        } else if (isRussianLetter(firstCharacter)) {
            for (int i = 0; i < russianConsonants.length; i++) {
                if (russianConsonants[i] == firstCharacter) {
                    hasConsonant = true;
                }
            }
        }
        return hasConsonant;
    }

    /**
     * Checks if letter is english or not
     * @param letter
     * @return boolean variable (is english or not)
     */
    public boolean isEnglishLetter(char letter) {
        int code = (int) letter;
        return ((code > 96 && code < 123) || (code > 64 && code < 91));
    }

    /**
     * Checks if letter is russian or not
     * @param letter
     * @return boolean variable (is english or not)
     */
    public boolean isRussianLetter(char letter) {
        int code = (int) letter; //UTF-8
        return (code > 1040 && code < 1104);
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
        List<StringBuilder> words = new ArrayList<>();
        int currentCharacterInWord = 0;
        int startOfWord = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                words.add(new StringBuilder(string.substring(startOfWord,
                        startOfWord + currentCharacterInWord)));
                startOfWord = i + 1;
                currentCharacterInWord = 0;
            } else {
                currentCharacterInWord++;
            }
        }
        words.add(new StringBuilder(string.substring(startOfWord,
                startOfWord + currentCharacterInWord)));
        return words;
    }

    /**
     * Removes extra character from string. Leaves only letters (english, russian) and spaces
     * @param string
     * @return string without extra characters
     */
    @Override
    public StringBuilder removeExtraCharacters(StringBuilder string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            if ((currentCharacter == ' ' && result.length() > 0 && result.charAt(result.length() - 1) != ' ')
                    || (isEnglishLetter(currentCharacter)) || isRussianLetter(currentCharacter)) {
                result.append(currentCharacter);
            }
        }
        //TODO ?
        return result;
    }
}
