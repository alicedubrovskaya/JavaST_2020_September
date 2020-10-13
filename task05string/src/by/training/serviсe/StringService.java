package by.training.serviсe;

import java.util.List;

public interface StringService {
    List<StringBuilder> getWords();

    void saveText(List<StringBuilder> words);

    StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder word);

    StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder word);

    StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite);

    boolean startsWithConsonant(StringBuilder word);
}
