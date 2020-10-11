package by.training.serviсe;

import java.util.Arrays;

/**
 * Class is an implementation of interface StringService
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class StringServiceImpl implements StringService {

    @Override
    public char[] replaceLetterWithAGivenCharacter(char character, int k, char[] string) {
        char resultingString[] = new char[string.length];
        int positionForK = 0;

        for (int i = 0; i < string.length; i++) {
            positionForK++;
            if (positionForK == k) {
                resultingString[i] = character;
                positionForK = 0;
            } else {
                resultingString[i] = string[i];
            }
        }
        return resultingString;
    }

    @Override
    public char[] changeIncorrectCharacters(char preceding, char incorrect, char needed, char[] string) {
        char[] resultingString = new char[string.length];

        for (int i = 0; i < string.length; i++) {
            if (i != 0 && string[i - 1] == preceding && string[i] == incorrect) {
                resultingString[i] = needed;
            } else {
                resultingString[i] = string[i];
            }
        }
        return resultingString;
    }

    /**
     * Parsers string of chars to array of words.
     * The string is assumed to contain only words and spaces (single) between words
     *
     * @param string
     * @return array of words
     */
    @Override
    public char[][] parseStringToArrayOfWords(char[] string) {
        char[][] result = new char[string.length][];
        int currentCharacterInWord = 0;
        int startOfWord = 0;
        int currentWordInResult = 0;

        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                result[currentWordInResult] = new char[currentCharacterInWord];
                System.arraycopy(string, startOfWord, result[currentWordInResult], 0, currentCharacterInWord);
                startOfWord = i + 1;
                currentWordInResult++;
                currentCharacterInWord = 0;
            } else {
                currentCharacterInWord++;
            }
        }
        result[currentWordInResult] = new char[currentCharacterInWord];
        System.arraycopy(string, startOfWord, result[currentWordInResult], 0, currentCharacterInWord);
        return result;
    }

    @Override
    public char[] removeExtraCharacters(char[] string) {
        char[] result;
        char[] correctDuplicate = new char[string.length];
        int currentCharacterInDuplicate = -1;

        for (int i = 0; i < string.length; i++) {
            isEnglishLetter(string[i]);
            isRussianLetter(string[i]);
            //space verification
            if (string[i] == ' ') {
                if (currentCharacterInDuplicate > 0) {
                    if (correctDuplicate[currentCharacterInDuplicate] != ' ') {
                        currentCharacterInDuplicate++;
                        correctDuplicate[currentCharacterInDuplicate] = ' ';
                    }
                }
            } else if (isEnglishLetter(string[i]) || isRussianLetter(string[i])) {
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
    public boolean isEnglishLetter(char letter) {
        int code = (int) letter;
        return ((code > 96 && code < 123) || (code > 64 && code < 91));
    }

    @Override
    public boolean isRussianLetter(char letter) {
        int code = (int) letter; //UTF-8
        return (code > 1040 && code < 1104);
    }
}
