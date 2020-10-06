package training.by.dao;

import training.by.entity.Array;
import training.by.entity.JaggedArray;
import training.by.entity.JaggedArrayList;
import training.by.exception.IncorrectTypeOfElementsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alisa Dubrovskaya
 */
public class ArrayDAOImpl implements ArrayDAO {
    private Array array;
    private JaggedArrayList jaggedArrayList;
    private int idJaggedArray;

    public ArrayDAOImpl() {
        this.jaggedArrayList=new JaggedArrayList();
        this.idJaggedArray=0;
    }

    @Override
    public int[] getElementsFromFile(String fileName) throws IOException {
        int[] arrayInt = new int[5];

        int i = 0;
        try (FileReader fr = new FileReader(fileName);
             Scanner scan = new Scanner(fr);
        ) {

            while (scan.hasNext()) {
                try {
                    arrayInt[i] = scan.nextInt();
                    i++;
                } catch (IncorrectTypeOfElementsException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return arrayInt;
    }

    @Override
    public Array getArray() {
        return array;
    }

    @Override
    public List<JaggedArray> getJaggedArrayList() {
        return jaggedArrayList.getJaggedArrays();
    }

    @Override
    public void createArrayWithElementsFromFile() {
        int[] arrayInt;
        String filePath = new File("task04array/data/elements.txt").getAbsolutePath();
        try {
            arrayInt = getElementsFromFile(filePath);
            //  validateElements(arrayInt);
            for (Integer element : arrayInt) {
                System.out.print(element + " ");
            }
            this.array = new Array(arrayInt);
        } catch (IOException e) {
            System.out.println("Array wasn't created");
        } catch (IncorrectTypeOfElementsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createJaggedArrayWithElementsFromFile() {

    }

    @Override
    public void createArray(Integer... elements) {
        this.array = new Array(elements);
    }

    @Override
    public int createArray(int[][] arrayInt){
        idJaggedArray++;
        JaggedArray jaggedArray=new JaggedArray(arrayInt, idJaggedArray);
        this.jaggedArrayList.add(jaggedArray);
        return jaggedArray.getId();
    }

}
