package by.training.serviсe;

import java.util.List;

public interface CharParserService {
    char[][] parseStringToWords(char[] string);

    char[] removeExtraCharacters(char[] string);
}
