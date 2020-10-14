package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.StringWordService;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWordServiceImpl implements StringWordService {
    private WordDAO wordDAO;

    public RegexWordServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
    }

    @Override
    public List<StringBuilder> getWords() {
        return wordDAO.convertToString(wordDAO.getText().getWords());
    }

    @Override
    public void saveText(List<StringBuilder> words) {
        wordDAO.createText(wordDAO.convert(words));
    }

    @Override
    public String getFromFile(String fileName) throws IOException {
        return wordDAO.getTextFromFile(fileName);
    }

    @Override
    public StringBuilder replaceLetterWithAGivenCharacter(char character, int k, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(.{%d}).", k - 1);
        return new StringBuilder(word.replaceAll(regex, "$1" + character));
    }

    @Override
    public StringBuilder changeIncorrectCharacters(char preceding, char incorrect, char needed, StringBuilder string) {
        String word = string.toString();
        String regex = String.format("(%s)%s", preceding, incorrect);
        return new StringBuilder(word.replaceAll(regex, "$1" + needed));
    }

    @Override
    public StringBuilder replaceWordOfSpecifiedLength(int length, StringBuilder word, StringBuilder wordToWrite) {
        String regex = String.format("^.{%d}$", length);
        return new StringBuilder(word.toString().replaceAll(regex, wordToWrite.toString()));
    }

    @Override
    public boolean startsWithConsonant(StringBuilder word) {
        Pattern pattern = Pattern.compile("[BСDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz].*");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    @Override
    public boolean isEnglishLetter(char letter) {
        return false;
    }

    @Override
    public boolean isRussianLetter(char letter) {
        return false;
    }
}
