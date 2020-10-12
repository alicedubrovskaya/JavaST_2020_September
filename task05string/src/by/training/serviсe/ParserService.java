package by.training.serviсe;

import java.util.List;

public interface ParserService {
    char[][] parseStringToWords(char[] string);

    List<StringBuilder> parseStringToWords(StringBuilder string);

    char[] removeExtraCharacters(char[] string);

    StringBuilder removeExtraCharacters(String string);




}
