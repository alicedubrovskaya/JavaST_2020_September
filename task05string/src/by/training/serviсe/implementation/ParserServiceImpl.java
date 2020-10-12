package by.training.serviсe.implementation;

import by.training.serviсe.CharArrayService;
import by.training.serviсe.ParserService;

import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private CharArrayService charArrayService;

    public ParserServiceImpl(CharArrayService charArrayService) {
        this.charArrayService = charArrayService;
    }

    /**
     * Parsers string of chars to array of words.
     * The string is assumed to contain only words and spaces (single) between words
     *
     * @param string
     * @return array of words
     */
    @Override
    public char[][] parseStringToWords(char[] string) {
        char[][] words = new char[string.length][];
        int currentCharacterInWord = 0;
        int startOfWord = 0;
        int currentWordInResult = 0;

        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                words[currentWordInResult] = new char[currentCharacterInWord];
                System.arraycopy(string, startOfWord, words[currentWordInResult], 0, currentCharacterInWord);
                startOfWord = i + 1;
                currentWordInResult++;
                currentCharacterInWord = 0;
            } else {
                currentCharacterInWord++;
            }
        }
        words[currentWordInResult] = new char[currentCharacterInWord];
        System.arraycopy(string, startOfWord, words[currentWordInResult], 0, currentCharacterInWord);
        return words;
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
        return words;
    }

    @Override
    public char[] removeExtraCharacters(char[] string) {
        char[] result;
        char[] correctDuplicate = new char[string.length];
        int currentCharacterInDuplicate = -1;

        for (int i = 0; i < string.length; i++) {
            if ((string[i] == ' ' && currentCharacterInDuplicate > 0 && correctDuplicate[currentCharacterInDuplicate] != ' ')
                    || (charArrayService.isEnglishLetter(string[i]) || charArrayService.isRussianLetter(string[i]))) {
                currentCharacterInDuplicate++;
                correctDuplicate[currentCharacterInDuplicate] = string[i];
            }
        }
        if (correctDuplicate[currentCharacterInDuplicate] != ' ') {
            currentCharacterInDuplicate++;
        }

        result = new char[currentCharacterInDuplicate];
        System.arraycopy(correctDuplicate, 0, result, 0, currentCharacterInDuplicate);

        return result;
    }

    @Override
    public StringBuilder removeExtraCharacters(String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            if ((currentCharacter == ' ' && result.length() > 0 && result.charAt(result.length() - 1) != ' ')
                    || (charArrayService.isEnglishLetter(currentCharacter)) || charArrayService.isRussianLetter(currentCharacter)) {
                result.append(currentCharacter);
            }
        }
        //TODO ?
        return result;
    }
}
