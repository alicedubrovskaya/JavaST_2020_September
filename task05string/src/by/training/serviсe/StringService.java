package by.training.serviсe;

/**
 * Interface for work with string
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public interface StringService {
    char[] replaceLetterWithAGivenCharacter(char character, int k, char[] string);

    char[] changeIncorrectCharacters(char preceding, char incorrect, char needed, char[] string);

    char[][] parseStringToArrayOfWords(char[] string);

    char[] removeExtraCharacters(char[] string);

    boolean isEnglishLetter(char letter);

    boolean isRussianLetter(char letter);

}
