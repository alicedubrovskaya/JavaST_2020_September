package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.service.BaseOperationsService;
import training.by.service.CreationService;

public class CreationServiceImpl implements CreationService {
    private ArrayDAO arrayDAO;
    private BaseOperationsService baseOperationsService;

    public CreationServiceImpl(BaseOperationsService baseOperationsService) {
        this.baseOperationsService = baseOperationsService;
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.arrayDAO = daoFactory.getArrayDAO();
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    @Override
    public void createArray(Integer... elements) {
        arrayDAO.createArray(elements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    @Override
    public void createArray() {
        arrayDAO.createArrayWithElementsFromFile();
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from file
     */
    @Override
    public void createJaggedArray(String filePath) {
        arrayDAO.createJaggedArrayWithElementsFromFile(filePath);
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from console
     *
     * @param jaggedArrayInt
     */
    @Override
    public int createArray(int[][] jaggedArrayInt) {
        return arrayDAO.createArray(jaggedArrayInt);
    }

    /**
     * Generates one dimensional array
     *
     * @param countOfElements
     * @return generated array
     */
    @Override
    public int[] generateOneDimensionalArray(int countOfElements) {
        int[] arrayInt = new int[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            arrayInt[i] = baseOperationsService.generateNumber();
        }
        return arrayInt;
    }

}
