package by.dubrovskaya.thread.dao.implementation;

import by.dubrovskaya.thread.dao.ThreadDao;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.entity.Storage;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;
import by.dubrovskaya.thread.exception.ThreadNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDaoImpl implements ThreadDao {
    private final Storage storage = Storage.getINSTANCE();
    private final Logger logger = LogManager.getLogger(getClass().getName());
    int currentThreadId = 0;

    public int newId() {
        return currentThreadId++;
    }

    @Override
    public void save(MatrixThread thread) throws ThreadAlreadyExistsException {
        if (!storage.exists(thread)) {
            thread.setName(String.format("Thread %d", newId()));
            storage.add(thread);
            logger.debug("Thread added to storage");
        } else {
            throw new ThreadAlreadyExistsException(thread.getValue());
        }
    }

    @Override
    public MatrixThread getThread(int index) throws ThreadNotFoundException {
        if (index >= 0 && index < storage.getCountOfThreads()) {
            return storage.getThread(index);
        } else {
            throw new ThreadNotFoundException(index);
        }
    }

    @Override
    public int getCount() {
        return storage.getCountOfThreads();
    }
}
