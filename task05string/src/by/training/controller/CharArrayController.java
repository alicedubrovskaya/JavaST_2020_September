package by.training.controller;

import by.training.serviсe.ParserService;
import by.training.serviсe.factory.ServiceFactory;
import by.training.serviсe.CharArrayService;

import java.io.IOException;

public class CharArrayController {
    private CharArrayService charArrayService;
    private ParserService parserService;

    public CharArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.charArrayService = serviceFactory.getCharArrayService();
        this.parserService=serviceFactory.getParserService();
    }

    public void saveText(char[] string) {
        charArrayService.saveText(parseStringToArrayOfWords(string));
    }

    public void saveText(String fileName) {
        try {
            char[][] words = parseStringToArrayOfWords(charArrayService.getFromFile(fileName));
            charArrayService.saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public char[][] replaceNeededLettersWithAGivenCharacter(char character, int k) {
        char[][] words = charArrayService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = charArrayService.replaceLetterWithAGivenCharacter(character, k, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed) {
        char[][] words = charArrayService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                result[i] = charArrayService.changeIncorrectCharacters(preceding, incorrect, needed, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite) {
        char[][] words = charArrayService.getWords();
        char[][] result = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                char[] wordNew = charArrayService.replaceWordOfSpecifiedLength(lengthOfWordsToReplace, words[i], wordToWrite);
                if (wordNew != null) {
                    result[i] = wordNew;
                } else {
                    result[i] = words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] wordsWithoutConsonantsAtTheBeginning() {
        char[][] words = charArrayService.getWords();
        //TODO remove fixed length
        char[][] result = new char[words.length][];
        int currentWordInResult = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                if (!charArrayService.startsWithConsonant(words[i])) {
                    currentWordInResult++;
                    result[currentWordInResult] = words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] parseStringToArrayOfWords(char[] string) {
        char[] stringWithoutExtraCharacters = parserService.removeExtraCharacters(string);
        return parserService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
