package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.dao.DaoFactory;
import by.dubrovskaya.thread.dao.MatrixDao;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.service.MatrixService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixServiceImpl implements MatrixService {
    private MatrixDao matrixDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public MatrixServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getINSTANCE();
        this.matrixDao = daoFactory.getMatrixDao();
    }

    @Override
    public void save(Matrix matrix) {
        logger.debug("Adding of matrix");
        matrixDao.save(matrix);
    }
}
