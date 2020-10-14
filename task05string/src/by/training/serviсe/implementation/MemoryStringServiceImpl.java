package by.training.serviсe.implementation;

import by.training.dao.DAOFactory;
import by.training.dao.WordDAO;
import by.training.serviсe.MemoryStringService;

import java.io.IOException;
import java.util.List;

public class MemoryStringServiceImpl implements MemoryStringService {
    private WordDAO wordDAO;

    public MemoryStringServiceImpl() {
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
}
