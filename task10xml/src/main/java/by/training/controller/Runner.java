package by.training.controller;

import by.training.parser.AbstractMedicinesBuilder;
import by.training.parser.MedicineBuilderFactory;
import by.training.parser.stax.MedicinesStAXBuilder;
import org.xml.sax.SAXException;

public class Runner {
    public static void main(String[] args) throws SAXException {
        MedicineBuilderFactory medicineBuilderFactory = new MedicineBuilderFactory();
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("stax");
        builder.buildSetMedicines("task10xml/src/main/resources/medicines.xml");
        System.out.println(builder.getMedicines());

//        DomMedicinesBuilder domMedicinesBuilder = new DomMedicinesBuilder();
//        domMedicinesBuilder.buildSetMedicines(
//                "task10xml/src/main/resources/medicines.xml",
//                "task10xml/src/main/resources/medicines.xsd"
//        );


//        MedicinesSAXBuilder saxBuilder = new MedicinesSAXBuilder();
//        saxBuilder.buildSetMedicines("task10xml/src/main/resources/medicines.xml");
//        System.out.println(saxBuilder.getMedicines());

//        MedicinesStAXBuilder staxBuilder = new MedicinesStAXBuilder();
//        staxBuilder.buildSetMedicines("task10xml/src/main/resources/medicines.xml");
//        System.out.println(staxBuilder.getMedicines());
    }
}
