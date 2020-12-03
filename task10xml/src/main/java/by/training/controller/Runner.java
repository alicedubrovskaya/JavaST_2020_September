package by.training.controller;

import by.training.parser.AbstractMedicinesBuilder;
import by.training.parser.MedicineBuilderFactory;
import by.training.parser.stax.MedicinesStAXBuilder;
import org.xml.sax.SAXException;

public class Runner {
    public static void main(String[] args) throws SAXException {
        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("dom");
        builder.buildSetMedicines("task10xml/src/main/resources/medicines.xml");
        System.out.println(builder.getMedicines());

    }
}
