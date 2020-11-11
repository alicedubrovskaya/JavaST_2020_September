package by.dubrovskaya.thread.service.factory;

import by.dubrovskaya.thread.entity.ThreadExecution;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import by.dubrovskaya.thread.service.crud.ThreadCrudService;
import by.dubrovskaya.thread.service.implementation.operation.ExecutorMatrixServiceImpl;
import by.dubrovskaya.thread.service.implementation.operation.MatrixServiceImpl;

public class MatrixServiceFactory {
    /**
     * Returns implementation of Matrix Service depending on transmitted type
     *
     * @param execution
     * @param threadCrudService
     * @param matrixCrudService
     * @return
     */
    public MatrixService getMatrixService(ThreadExecution execution, ThreadCrudService threadCrudService,
                                          MatrixCrudService matrixCrudService) {
        if (ThreadExecution.EXECUTOR.equals(execution)) {
            return new ExecutorMatrixServiceImpl(threadCrudService, matrixCrudService);
        } else if (ThreadExecution.LOCKER.equals(execution) || ThreadExecution.SEMAPHORE.equals(execution)) {
            return new MatrixServiceImpl(threadCrudService, matrixCrudService);
        }
        return null;
    }
}
