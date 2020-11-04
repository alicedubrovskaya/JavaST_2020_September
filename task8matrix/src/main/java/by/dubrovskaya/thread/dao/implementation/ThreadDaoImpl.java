package by.dubrovskaya.thread.dao.implementation;

import by.dubrovskaya.thread.dao.ThreadDao;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.entity.Storage;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDaoImpl implements ThreadDao {
    private final Storage storage = Storage.getINSTANCE();
    private final Logger logger = LogManager.getLogger(getClass().getName());

    @Override
    public void save(MatrixThread thread) throws ThreadAlreadyExistsException {
        if (!storage.exists(thread)) {
            storage.add(thread);
            logger.debug("Thread added to storage");
        } else {
            throw new ThreadAlreadyExistsException(thread.getValue());
        }
    }
}
