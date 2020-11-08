package by.dubrovskaya.thread.dao.implementation;

import by.dubrovskaya.thread.dao.MatrixDao;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.Storage;
import by.dubrovskaya.thread.exception.MatrixNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Class that is an implementation of interface MatrixDao
 *
 * @author Alisa Dubrovskaya
 */
public class MatrixDaoImpl implements MatrixDao {
    private final Storage storage = Storage.getINSTANCE();
    private final Logger logger = LogManager.getLogger(getClass().getName());

    /**
     * Saves matrix
     * @param matrix
     */
    @Override
    public void save(Matrix matrix) {
        logger.info("Saving matrix");
        storage.add(matrix);
        logger.debug("Matrix added to storage");
    }

    /**
     * Gets matrix
     * @return
     * @throws MatrixNotFoundException
     */
    @Override
    public Matrix get() throws MatrixNotFoundException{
        logger.info("Getting matrix");
        Matrix matrix = storage.getMatrix();
        if (matrix==null){
            throw new MatrixNotFoundException();
        }
        return matrix;
    }
}
