package by.training.serviсe;

import java.io.IOException;

/**
 * Interface for work with string
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public interface StringService {
    void saveText(char[][] words);

    char[][] getWords();

    char[] getFromFile(String fileName) throws IOException;

    char[] replaceLetterWithAGivenCharacter(char character, int k, char[] string);

    char[] changeIncorrectCharacters(char preceding, char incorrect, char needed, char[] string);

    char[] replaceWordOfSpecifiedLength(int length, char[] word, char[] wordToWrite);

    char[][] parseStringToArrayOfWords(char[] string);

    char[] removeExtraCharacters(char[] string);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);

    boolean startsWithConsonant(char[] word);
}
