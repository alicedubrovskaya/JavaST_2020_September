package by.training.serviсe.implementation;

import by.training.dao.WordDAO;
import by.training.dao.DAOFactory;
import by.training.serviсe.CharArrayService;
import by.training.serviсe.StringService;

import java.util.List;

public class StringServiceImpl implements StringService {
    private WordDAO wordDAO;
    private CharArrayService charArrayService;
    //TODO upperCase
    private static final char[] englishConsonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q',
            'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] russianConsonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р',
            'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

    public StringServiceImpl(CharArrayService charArrayService) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
        this.charArrayService = charArrayService;
    }

    @Override
    public List<StringBuilder> getWords() {
        return wordDAO.getText().getWordsString();
    }

    @Override
    public void saveText(List<StringBuilder> words) {
        wordDAO.createText(words);
    }

    @Override
    public StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder word) {
        StringBuilder result = new StringBuilder();
        int positionForK = 0;

        for (int i = 0; i < word.length(); i++) {
            positionForK++;
            if (positionForK == k) {
                result.append(character);
                positionForK = 0;
            } else {
                result.append(word.charAt(i));
            }
        }

        return result;
    }

    @Override
    public StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder word) {
        StringBuilder resultingString = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && word.charAt(i - 1) == preceding && word.charAt(i) == incorrect) {
                resultingString.append(needed);
            } else {
                resultingString.append(word.charAt(i));
            }
        }
        return resultingString;
    }

    @Override
    public StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite) {
        StringBuilder result;
        if (length == word.length()) {
            result = new StringBuilder(wordToWrite);
        } else {
            result = new StringBuilder(word);
        }
        return result;
    }

    @Override
    public boolean startsWithConsonant(StringBuilder word) {
        boolean hasConsonant = false;
        char firstCharacter = word.charAt(0);

        if (charArrayService.isEnglishLetter(firstCharacter)) {
            for (int i = 0; i < englishConsonants.length; i++) {
                if (englishConsonants[i] == firstCharacter) {
                    hasConsonant = true;
                }
            }
        } else if (charArrayService.isRussianLetter(firstCharacter)) {
            for (int i = 0; i < russianConsonants.length; i++) {
                if (russianConsonants[i] == firstCharacter) {
                    hasConsonant = true;
                }
            }
        }
        return hasConsonant;
    }
}
