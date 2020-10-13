package by.training.serviсe;

import java.io.IOException;

public interface CharWordService {
    char[][] getWords();

    void saveText(char[][] words);

    String getFromFile(String fileName) throws IOException;

    char[] replaceLetterWithAGivenCharacter(char character, int k, char[] string);

    char[] changeIncorrectCharacters(char preceding, char incorrect, char needed, char[] string);

    char[] replaceWordOfSpecifiedLength(int length, char[] word, char[] wordToWrite);

    boolean startsWithConsonant(char[] word);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);
}
