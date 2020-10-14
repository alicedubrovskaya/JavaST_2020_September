package by.training.serviсe;

import java.util.List;

/**
 * Interface for work with words, which type is StringBuilder
 *
 * @author Alisa Dubrovskaya
 */
public interface StringWordService {
    StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string);

    StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string);

    StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite);

    boolean startsWithConsonant(StringBuilder word);

    List<StringBuilder> parseStringToWords(StringBuilder string);

    StringBuilder removeExtraCharacters(StringBuilder string);
}
