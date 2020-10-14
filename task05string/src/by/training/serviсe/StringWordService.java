package by.training.serviсe;

public interface StringWordService {
    StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string);

    StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string);

    StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite);

    boolean startsWithConsonant(StringBuilder word);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);
}
