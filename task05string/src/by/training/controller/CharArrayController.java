package by.training.controller;

import by.training.serviсe.CharParserService;
import by.training.serviсe.CharWordService;
import by.training.serviсe.factory.FactoryService;

public class CharArrayController {
    private CharWordService wordService;
    private CharParserService parserService;

    public CharArrayController() {
        FactoryService factoryService = FactoryService.getInstance();
        this.wordService = factoryService.getCharWordService();
        this.parserService = factoryService.getCharParserService();
    }

    public void saveText(String string) {
        wordService.saveText(parseStringToArrayOfWords(string));
    }

   /* public void saveText(String fileName) {
        try {
            char[][] words = parseStringToArrayOfWords(wordService.getFromFile(fileName));
            wordService.saveText(words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    */
    public char[][] replaceNeededLettersWithAGivenCharacter(char character, int k) {
        char[][] words = wordService.getWords();
        char[][] result = new char[words.length][];

        for (int i=0;i<words.length;i++) {
            if (words[i] != null) {
                result[i]= wordService.replaceLetterWithAGivenCharacter(character, k, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] fixIncorrectLetters(char preceding, char incorrect, char needed) {
        char[][] words = wordService.getWords();
        char[][] result = new char[words.length][];

        for (int i=0;i<words.length;i++) {
            if (words[i] != null) {
                result[i]=  wordService.changeIncorrectCharacters(preceding, incorrect, needed, words[i]);
            } else {
                break;
            }
        }
        return result;
    }

    public  char[][] replaceWordsOfSpecifiedLength(int lengthOfWordsToReplace, char[] wordToWrite) {
        char[][] words = wordService.getWords();
        char[][] result = new char[words.length][];

        for (int i=0;i<words.length;i++) {
            if (words[i] != null) {
                result[i]= wordService.replaceWordOfSpecifiedLength(lengthOfWordsToReplace,words[i], wordToWrite);
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] wordsWithoutConsonantsAtTheBeginning() {
        char[][] words = wordService.getWords();
        char[][] result = new char[words.length][];

        int currentWordInResult = -1;
        for (int i=0;i<words.length;i++) {
            if (words[i] != null) {
                if (!wordService.startsWithConsonant(words[i])) {
                    result[i]= words[i];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public char[][] parseStringToArrayOfWords(String string) {
        char[] stringWithoutExtraCharacters = parserService.removeExtraCharacters(string.toCharArray());
        return parserService.parseStringToWords(stringWithoutExtraCharacters);
    }
}
