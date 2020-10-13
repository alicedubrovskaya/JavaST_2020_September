package by.training.serviсe.implementation;

import by.training.serviсe.StringParserService;
import by.training.serviсe.CharWordService;

import java.util.ArrayList;
import java.util.List;

public class StringParserServiceImpl implements StringParserService {
    private CharWordService charWordService;

    public StringParserServiceImpl(CharWordService charWordService) {
        this.charWordService = charWordService;
    }

    @Override
    public List<StringBuilder> parseStringToWords(StringBuilder string) {
        List<StringBuilder> words = new ArrayList<>();
        int currentCharacterInWord = 0;
        int startOfWord = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                words.add(new StringBuilder(string.substring(startOfWord,
                        startOfWord + currentCharacterInWord)));
                startOfWord = i + 1;
                currentCharacterInWord = 0;
            } else {
                currentCharacterInWord++;
            }
        }
        return words;
    }

    @Override
    public StringBuilder removeExtraCharacters(StringBuilder string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentCharacter = string.charAt(i);
            if ((currentCharacter == ' ' && result.length() > 0 && result.charAt(result.length() - 1) != ' ')
                    || (charWordService.isEnglishLetter(currentCharacter)) || charWordService.isRussianLetter(currentCharacter)) {
                result.append(currentCharacter);
            }
        }
        //TODO ?
        return result;
    }
}
