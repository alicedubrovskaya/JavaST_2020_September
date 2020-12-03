package by.training.xml.parser.sax;


import by.training.xml.entity.Medicine;
import by.training.xml.parser.AbstractMedicinesBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MedicinesSAXBuilder extends AbstractMedicinesBuilder {
    private List<Medicine> medicines;
    private MedicineHandler medicineHandler;
    private XMLReader reader;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public MedicinesSAXBuilder() {
        medicineHandler = new MedicineHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(medicineHandler);
        } catch (SAXException e) {
           logger.error("ошибка SAX парсера: {} ",e.getMessage());
        }
    }

    public MedicinesSAXBuilder (List<Medicine> medicines) {
        super(medicines);
    }

    public void buildSetMedicines(String fileName) {
        try {
            FileInputStream inputStream  = new FileInputStream(new File(fileName));
            reader.parse(String.valueOf(inputStream));
        } catch (SAXException e) {
            logger.error("ошибка SAX парсера:{} ",e.getMessage());
        } catch (IOException e) {
            logger.error("ошибка I/О потока: {}", e.getMessage());
        }
        medicines =  medicineHandler.getMedicines();
    }
}
