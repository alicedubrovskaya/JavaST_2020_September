package by.training.serviсe;

import java.util.List;

public interface ParserService {
    List<StringBuilder> parseStringToWords(StringBuilder string);

    StringBuilder removeExtraCharacters(StringBuilder string);

    char[][] parseStringToWords(char[] string);

    char[] removeExtraCharacters(char[] string);
}
