package by.training.dao;

import by.training.entity.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public void createText(List<StringBuilder> words) {
        text=new Text(words);
    }

    @Override
    public Text getText() {
        return text;
    }

    @Override
    public char[] getTextFromFile(String fileName) throws IOException {
        //TODO multiple lines

        String filePath = new File(fileName).getAbsolutePath();
        char[] string = null;
        try (FileReader fr = new FileReader(filePath);
             Scanner in = new Scanner(fr);
        ) {
            in.useDelimiter("\n");
            string = in.nextLine().toCharArray();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return string;
    }
}
