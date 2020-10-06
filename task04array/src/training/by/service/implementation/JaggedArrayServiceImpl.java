package training.by.service.implementation;

import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;

public class JaggedArrayServiceImpl implements JaggedArrayService {
    private BaseOperationsService baseOperationsService;

    public JaggedArrayServiceImpl(BaseOperationsService baseOperationsService) {
        this.baseOperationsService = baseOperationsService;
    }
}
