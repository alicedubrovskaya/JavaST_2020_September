package by.training.controller;

import by.training.parser.dom.DomMedicinesBuilder;
import by.training.parser.sax.MedicinesSAXBuilder;
import org.xml.sax.SAXException;

public class Runner {
    public static void main(String[] args) throws SAXException {
//        DomMedicinesBuilder domMedicinesBuilder = new DomMedicinesBuilder();
//        domMedicinesBuilder.buildSetMedicines(
//                "task10xml/src/main/resources/medicines.xml",
//                "task10xml/src/main/resources/medicines.xsd"
//        );


        MedicinesSAXBuilder saxBuilder = new MedicinesSAXBuilder();
        saxBuilder.buildSetMedicines("task10xml/src/main/resources/medicines.xml");
        System.out.println(saxBuilder.getMedicines());
    }
}
