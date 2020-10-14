package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.CharWordService;

/**
 * Class is an implementation of interface StringService
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class CharWordServiceImpl implements CharWordService {
    //TODO upperCase
    private static final char[] englishConsonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
            'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] russianConsonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р',
            'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

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

    @Override
    public char[] replaceWordOfSpecifiedLength(int length, char[] word, char[] wordToWrite) {
        char[] result;
        if (length == word.length) {
            result = wordToWrite;
        } else {
            result = word;
        }
        return result;
    }

    @Override
    public boolean startsWithConsonant(char[] word) {
        boolean hasConsonant = false;
        char firstCharacter = word[0];

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
                    || (isEnglishLetter(string[i]) || isRussianLetter(string[i]))) {
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
