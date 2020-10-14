package by.training.serviсe.implementation;

import by.training.serviсe.StringWordService;

import java.util.ArrayList;
import java.util.List;

public class StringWordServiceImpl implements StringWordService {
    //TODO upperCase
    private static final char[] englishConsonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
            'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] russianConsonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р',
            'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

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

    public boolean isEnglishLetter(char letter) {
        int code = (int) letter;
        return ((code > 96 && code < 123) || (code > 64 && code < 91));
    }

    public boolean isRussianLetter(char letter) {
        int code = (int) letter; //UTF-8
        return (code > 1040 && code < 1104);
    }

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
