package by.training.xml.controller.console;


import by.training.xml.entity.Medicine;
import by.training.xml.entity.enumeration.CommandType;
import by.training.xml.parser.AbstractMedicinesBuilder;
import by.training.xml.parser.MedicineBuilderFactory;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * This interface is responsible for executing requests sent with the command
 *
 * @author Alisa Dubrovskaya
 */
public class Receiver {
    private Scanner in;
    MedicineBuilderFactory medicineBuilderFactory;
    private static final String PATH="src/main/resources/medicine/medicines.xml";
    private static final String XML_PATH = new File(PATH).getAbsolutePath();

    public Receiver() {
        this.in = new Scanner(System.in);
        this.in.useDelimiter("\n");
        medicineBuilderFactory = new MedicineBuilderFactory();
    }

    public void action(CommandType option) {
        switch (option) {
            case DOM:
                parseWithDOM();
                break;
            case SAX:
                parseWIthSAX();
                break;
            case STAX:
                parseWithStAX();
                break;
            default:
        }
    }

    public void parseWithDOM() {
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("dom");
        builder.buildSetMedicines(XML_PATH);
    }

    public void parseWIthSAX() {
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("sax");
        builder.buildSetMedicines(PATH);
    }

    public void parseWithStAX() {
        AbstractMedicinesBuilder builder = medicineBuilderFactory.createMedicineBuilder("stax");
        builder.buildSetMedicines(XML_PATH);
    }
}
