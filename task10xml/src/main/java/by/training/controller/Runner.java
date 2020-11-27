package by.training.controller;

import by.training.parser.DomMedicinesBuilder;
import org.xml.sax.SAXException;

public class Runner {
    public static void main(String[] args) throws SAXException {
        DomMedicinesBuilder domMedicinesBuilder = new DomMedicinesBuilder();
        domMedicinesBuilder.buildSetMedicines(
                "task10xml/src/main/resources/medicines.xml",
                "task10xml/src/main/resources/medicines.xsd"
        );
    }
}
