package training.by.dao;

import training.by.entity.Array;
import training.by.entity.ArrayList;
import training.by.entity.JaggedArray;
import training.by.entity.JaggedArrayList;
import training.by.exception.IncorrectTypeOfElementsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Class that is an implementation of interface ArrayDAO
 *
 * @author Alisa Dubrovskaya
 */
public class ArrayDAOImpl implements ArrayDAO {
    private ArrayList arrayList;
    private JaggedArrayList jaggedArrayList;

    public ArrayDAOImpl() {
        this.arrayList = new ArrayList();
        this.jaggedArrayList = new JaggedArrayList();
    }

    /**
     * Receives elements from file with specified file name
     *
     * @param fileName
     * @return
     * @throws IOException
     */
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

    /**
     * Receives elements of jagged array from file with specified file name
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    @Override
    public int[][] getElementsOfJaggedArrayFromFile(String fileName) throws IOException {
        try (FileReader fr = new FileReader(fileName);
             Scanner scan = new Scanner(fr);
        ) {
            int countOfRows = scan.nextInt();
            int[][] array = new int[countOfRows][];

            for (int currentRow = 0; currentRow < countOfRows; currentRow++) {
                if (currentRow != countOfRows - 1) {
                    scan.nextLine(); //for correct input
                }
                array[currentRow] = parseStringToIntegerElements(scan.nextLine());

            }
            return array;
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return null;
    }


    @Override
    public Array getArray(int i) {
        return arrayList.getArray(i);
    }

    @Override
    public JaggedArray getJaggedArray(int position) {
        return jaggedArrayList.getArray(position);
    }

    /**
     * Creates array with elements from file
     */
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
            this.arrayList.addArray(new Array(arrayInt));
        } catch (IOException e) {
            System.out.println("Array wasn't created");
        } catch (IncorrectTypeOfElementsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates jagged array with elements from file
     * Example of path: "task04array/data/elements.txt"
     */
    @Override
    public void createJaggedArrayWithElementsFromFile(String path) {
        int[][] arrayInt;
        String filePath = new File(path).getAbsolutePath();
        try {
            arrayInt = getElementsOfJaggedArrayFromFile(filePath);
            createArray(arrayInt);
        } catch (IOException e) {
            System.out.println("Array wasn't created");
        } catch (IncorrectTypeOfElementsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createArray(Integer... elements) {
        arrayList.addArray(new Array(elements));
    }

    @Override
    public int createArray(int[][] arrayInt) {
        JaggedArray jaggedArray = new JaggedArray(arrayInt);
        this.jaggedArrayList.add(jaggedArray);
        return jaggedArrayList.getSize()-1;
    }

    /**
     * Parsers string of elements to array
     *
     * @param line
     * @return
     */
    @Override
    public int[] parseStringToIntegerElements(String line) {
        String[] elementsInRow = line.split(" ");
        int[] row = new int[elementsInRow.length];

        int currentColumn = 0;
        for (String element : elementsInRow) {
            row[currentColumn] = Integer.valueOf(element);
            currentColumn++;
        }
        return row;
    }
}
