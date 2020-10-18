package by.training.dao.implementation;

import by.training.dao.AuthorDao;
import by.training.entity.data.AuthorList;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private AuthorList authorList = new AuthorList();

    @Override
    public void addNewAuthors(List<String> authors) {
        for (String author : authors) {
            if (!authorList.authorExists(author)) {
                authorList.add(author);
            }
        }
    }
}
