package by.training.serviсe;

import java.io.IOException;
import java.util.List;

public interface StringWordService {
    List<StringBuilder> getWords();

    void saveText(List<StringBuilder> words);

    String getFromFile(String fileName) throws IOException;

    StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string);

    StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string);

    StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite);

    boolean startsWithConsonant(StringBuilder word);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);
}
