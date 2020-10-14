package by.training.serviсe;

import java.util.List;

public interface StringWordService {
    StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string);

    StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string);

    StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite);

    boolean startsWithConsonant(StringBuilder word);

    List<StringBuilder> parseStringToWords(StringBuilder string);

    StringBuilder removeExtraCharacters(StringBuilder string);
}
