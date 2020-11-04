package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.dao.DaoFactory;
import by.dubrovskaya.thread.dao.ThreadDao;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;
import by.dubrovskaya.thread.exception.ThreadNotFoundException;
import by.dubrovskaya.thread.service.ThreadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadServiceImpl implements ThreadService {
    private ThreadDao threadDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public ThreadServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getINSTANCE();
        this.threadDao = daoFactory.getThreadDao();
    }

    @Override
    public void save(MatrixThread thread) {
        try {
            threadDao.save(thread);
            logger.debug("Adding of thread");
        } catch (ThreadAlreadyExistsException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public MatrixThread get(int index) {
        MatrixThread matrixThread = null;
        try {
            logger.debug("Getting of thread");
            matrixThread = threadDao.getThread(index);
        } catch (ThreadNotFoundException e) {
            logger.error(e.getMessage());
        }
        return matrixThread;
    }

    @Override
    public int getCountOfThreads() {
        return threadDao.getCount();
    }
}
