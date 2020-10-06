package training.by.controller;

import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;
import training.by.service.ServiceFactory;

public class JaggedArrayController {
    private JaggedArrayService jaggedArrayService;
    private BaseOperationsService baseOperationsService;

    public JaggedArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.jaggedArrayService = serviceFactory.getJaggedArrayService();
        this.baseOperationsService=serviceFactory.getBaseOperationsService();
    }

    /**
     * Creates new exemplar of class JaggedArray with automatically generated elements
     */
    public void createNewArray(int rowCount, int columnCount) {
        baseOperationsService.createGeneratedArray(rowCount,columnCount);
    }
}
