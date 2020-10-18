package training.by.service;

public interface CreationService {
    void createArray(Integer... elements);

    void createArray();

    void createJaggedArray(String filePath);

    int createArray(int[][] jaggedArrayInt);

    int[] generateOneDimensionalArray(int countOfElements);
}
