package by.training.xml.controller.web;

import by.training.xml.entity.Medicine;
import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;
import java.util.List;

public class Controller {
    private static final String XML_PATH = "src/main/resources/medicine/medicines.xml";
    private final Logger logger = LogManager.getLogger(getClass().getName());


    public List<Medicine> parseXML(String parserType, String pathToProject) {
        logger.info("Parsing of xml file");

        logger.debug("Parser type: {}", parserType);
        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder(parserType);

        pathToProject = pathToProject.substring(0, pathToProject.indexOf("target"));
        String path = Paths.get(pathToProject + XML_PATH).toString();

        logger.debug("Path to xml file: {}", path);
        builder.buildSetMedicines(path);
        return builder.getMedicines();
    }

}
