package by.training.xml.controller.web;

import by.training.xml.entity.Medicine;
import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Controller {
    private static final String XML_PATH = "src/main/resources/medicine/medicines.xml";

    public List<Medicine> parseXML(String parserType, String pathToProject) {
        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder(parserType);

        pathToProject = pathToProject.substring(0, pathToProject.indexOf("target"));
        Path path = Paths.get(pathToProject + XML_PATH);

        builder.buildSetMedicines(path.toString());
        return builder.getMedicines();
    }

}
