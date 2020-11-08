package by.dubrovskaya.thread.service.factory;

import by.dubrovskaya.thread.service.MatrixCrudService;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.ThreadCrudService;
import by.dubrovskaya.thread.service.implementation.operation.ExecutorMatrixServiceImpl;
import by.dubrovskaya.thread.service.implementation.operation.MatrixServiceImpl;

public class MatrixServiceFactory {
    private final String EXECUTOR = "EXECUTOR";
    private final String SERVICE = "SERVICE";

    /**
     * Returns implementation of Matrix Service depending on transmitted type
     *
     * @param type
     * @return
     */
    public MatrixService getMatrixService(String type, ThreadCrudService threadCrudService,
                                          MatrixCrudService matrixCrudService) {
        if (EXECUTOR.equals(type)) {
            return new ExecutorMatrixServiceImpl(threadCrudService,matrixCrudService);
        } else if (SERVICE.equals(type)) {
            return new MatrixServiceImpl(threadCrudService, matrixCrudService);
        }
        return null;
    }
}
