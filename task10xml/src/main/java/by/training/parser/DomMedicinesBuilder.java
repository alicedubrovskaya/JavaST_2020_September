package by.training.parser;

import by.training.entity.Medicine;
import by.training.entity.enumeration.Group;
import by.training.entity.list.MedicineList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DomMedicinesBuilder {
    private MedicineList medicines;
    private DocumentBuilder documentBuilder;

    public DomMedicinesBuilder() {
        this.medicines = new MedicineList();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Configuration error: " + e);
        }
    }

    public void buildSetMedicines(String xmlPath, String xsdPath) throws SAXException {

//        /* Validation */

        Document doc = null;
        try {
            doc = documentBuilder.parse(new File(xmlPath));

            Element root = doc.getDocumentElement();
            NodeList medicineList = root.getElementsByTagName("medicine");

            for (int i = 0; i < medicineList.getLength(); i++) {
                Element medicineElement = (Element) medicineList.item(i);
                Medicine student = buildMedicine(medicineElement);
                medicines.addMedicine(student);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();

        medicine.setName(getChildValue(medicineElement, "name"));
        medicine.setPharm(getChildValue(medicineElement, "pharm"));

        medicine.setGroup(Group.getEnum(getChildValue(medicineElement, "group")));

        NodeList nodeList = medicineElement.getElementsByTagName("analog");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element analogNode = (Element) nodeList.item(i);
            medicine.addAnalog(analogNode.getFirstChild().getNodeValue());
        }

        return medicine;
    }

    private static Element getChild(final Element parent,
                                    final String childName) {
        NodeList nodeList =
                parent.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }

    private static String getChildValue(final Element parent,
                                        final String childName) {
        Element child = getChild(parent, childName);
        Node node = child.getFirstChild();
        return node.getNodeValue();
    }

    public MedicineList getMedicines() {
        return medicines;
    }
}
