package by.training.dao;

import by.training.entity.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that is an implementation of interface StringDAO
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class WordDAOImpl implements WordDAO {
    private Text text;

    @Override
    public void createText(char[][] words) {
        text = new Text(words);
    }

    @Override
    public char[][] convert(List<StringBuilder> words) {
        char[][] wordsResult = new char[words.size()][];

        for (int i = 0; i < words.size(); i++) {
            wordsResult[i]=words.get(i).toString().toCharArray();
        }
        return wordsResult;
    }

    @Override
    public List<StringBuilder> convertToString(char[][] words) {
        List<StringBuilder> wordsResult = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            wordsResult.add(new StringBuilder(String.valueOf(words[i])));
        }
        return wordsResult;
    }

    @Override
    public Text getText() {
        return text;
    }

    @Override
    public String getTextFromFile(String fileName) throws IOException {
        //TODO multiple lines

        String filePath = new File(fileName).getAbsolutePath();
        String string = null;
        try (FileReader fr = new FileReader(filePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            string = in.nextLine();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return string;
    }

}
