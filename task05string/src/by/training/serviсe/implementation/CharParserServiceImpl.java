package by.training.serviсe.implementation;

import by.training.serviсe.CharParserService;
import by.training.serviсe.CharWordService;

public class CharParserServiceImpl implements CharParserService {
    private CharWordService charWordService;

    public CharParserServiceImpl(CharWordService charWordService) {
        this.charWordService = charWordService;
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
                Character[] word = new Character[currentCharacterInWord];
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
    public char[] removeExtraCharacters(char[] string) {
        char[] result;
        char[] correctDuplicate = new char[string.length];
        int currentCharacterInDuplicate = -1;

        for (int i = 0; i < string.length; i++) {
            if ((string[i] == ' ' && currentCharacterInDuplicate > 0 && correctDuplicate[currentCharacterInDuplicate] != ' ')
                    || (charWordService.isEnglishLetter(string[i]) || charWordService.isRussianLetter(string[i]))) {
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
}
