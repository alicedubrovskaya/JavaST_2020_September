package by.training.xml.parser;


import by.training.xml.entity.Medicine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMedicinesBuilder {
    protected List<Medicine> medicines;

    public AbstractMedicinesBuilder() {
        medicines = new ArrayList<>();
    }

    public AbstractMedicinesBuilder(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    abstract public void buildSetMedicines(String fileName);
}
