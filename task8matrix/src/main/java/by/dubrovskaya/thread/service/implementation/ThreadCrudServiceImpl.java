package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.dao.DaoFactory;
import by.dubrovskaya.thread.dao.ThreadDao;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;
import by.dubrovskaya.thread.exception.ThreadNotFoundException;
import by.dubrovskaya.thread.service.crud.ThreadCrudService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classs is an implementation of ThreadCrudService
 */
public class ThreadCrudServiceImpl implements ThreadCrudService {
    private ThreadDao threadDao;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public ThreadCrudServiceImpl() {
        DaoFactory daoFactory = DaoFactory.getINSTANCE();
        this.threadDao = daoFactory.getThreadDao();
    }

    /**
     * Saves thread
     *
     * @param thread
     */
    @Override
    public void save(MatrixThread thread) {
        try {
            threadDao.save(thread);
            logger.debug("Adding of thread");
        } catch (ThreadAlreadyExistsException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Gets thread by index
     *
     * @param index
     * @return
     */
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

    /**
     * Gets count of threads at storage
     *
     * @return
     */
    @Override
    public int getCountOfThreads() {
        return threadDao.getCount();
    }
}
