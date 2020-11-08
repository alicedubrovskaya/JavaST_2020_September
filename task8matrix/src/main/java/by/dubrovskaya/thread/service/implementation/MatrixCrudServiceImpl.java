package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.dao.DaoFactory;
import by.dubrovskaya.thread.dao.MatrixDao;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.exception.MatrixNotFoundException;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixCrudServiceImpl implements MatrixCrudService {
    private MatrixDao matrixDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public MatrixCrudServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getINSTANCE();
        this.matrixDao = daoFactory.getMatrixDao();
    }

    @Override
    public void save(Matrix matrix) {
        logger.debug("Adding of matrix");
        matrixDao.save(matrix);
    }

    @Override
    public Matrix get() {
        Matrix matrix = null;
        try {
            matrix = matrixDao.get();
        } catch (MatrixNotFoundException e) {
            logger.error(e.getMessage());
        }
        return matrix;
    }
}
