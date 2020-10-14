package by.training.serviсe;

public interface CharWordService {
    char[] replaceLetterWithAGivenCharacter(char character, int k, char[] string);

    char[] changeIncorrectCharacters(char preceding, char incorrect, char needed, char[] string);

    char[] replaceWordOfSpecifiedLength(int length, char[] word, char[] wordToWrite);

    boolean startsWithConsonant(char[] word);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);

    char[][] parseStringToWords(char[] string);

    char[] removeExtraCharacters(char[] string);
}
