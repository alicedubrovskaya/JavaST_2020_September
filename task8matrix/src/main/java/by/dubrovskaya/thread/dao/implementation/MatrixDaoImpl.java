package by.dubrovskaya.thread.dao.implementation;

import by.dubrovskaya.thread.dao.MatrixDao;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.Storage;
import by.dubrovskaya.thread.exception.MatrixNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixDaoImpl implements MatrixDao {
    private final Storage storage = Storage.getINSTANCE();
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void save(Matrix matrix) {
        storage.add(matrix);
        logger.debug("Matrix added to storage");
    }

    @Override
    public Matrix get() throws MatrixNotFoundException{
        Matrix matrix = storage.getMatrix();
        if (matrix==null){
            throw new MatrixNotFoundException();
        }
        return matrix;
    }
}
