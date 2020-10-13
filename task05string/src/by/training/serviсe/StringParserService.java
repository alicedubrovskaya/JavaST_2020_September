package by.training.serviсe;

import java.util.List;

public interface StringParserService {
    List<StringBuilder> parseStringToWords(StringBuilder string);

    StringBuilder removeExtraCharacters(StringBuilder string);
}
