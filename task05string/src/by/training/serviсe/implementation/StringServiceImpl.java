package by.training.serviсe.implementation;

import by.training.dao.WordDAO;
import by.training.dao.DAOFactory;
import by.training.serviсe.StringService;

import java.util.List;

public class StringServiceImpl implements StringService {
    private WordDAO wordDAO;

    public StringServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.wordDAO = daoFactory.getWordDAO();
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
}
