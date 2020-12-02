package by.training.xml.parser.dom;

import by.training.xml.entity.*;
import by.training.xml.entity.Package;
import by.training.xml.entity.enumeration.Consistence;
import by.training.xml.entity.enumeration.Group;
import by.training.xml.entity.enumeration.PackageType;
import by.training.xml.entity.enumeration.Period;
import by.training.xml.parser.AbstractMedicinesBuilder;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicinesDomBuilder extends AbstractMedicinesBuilder {
    private List<Medicine> medicines;
    private DocumentBuilder documentBuilder;

    public MedicinesDomBuilder() {
        this.medicines = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Configuration error: " + e);
        }
    }

    public MedicinesDomBuilder(List<Medicine> medicines){
        super(medicines);
    }


    @Override
    public void buildSetMedicines(String fileName) {

//        /* Validation */

        Document doc = null;
        try {
            doc = documentBuilder.parse(new File(fileName));

            Element root = doc.getDocumentElement();
            NodeList medicineList = root.getElementsByTagName("medicine");

            for (int i = 0; i < medicineList.getLength(); i++) {
                Element medicineElement = (Element) medicineList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
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

        NodeList versionNodes = medicineElement.getElementsByTagName("version");
        for (int i = 0; i < versionNodes.getLength(); i++) {
            Element versionNode = (Element) versionNodes.item(i);
            Version version = parseVersion(versionNode);
            medicine.addToVersionList(version);
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

    public Version parseVersion(Element versionElement) {
        Version version = new Version();
        Producer producer = new Producer();

        Element producerElement = getChild(versionElement, "producer");
        producer.setaPackage(parsePackage(getChild(producerElement, "package")));
        producer.setDosage(parseDosage(getChild(producerElement, "dosage")));

        Node nodeSimpleCertificate = getChild(producerElement, "certificate");
        Node nodeLimitedCertificate = getChild(producerElement, "limited_certificate");
        if (nodeSimpleCertificate != null) {
            producer.setCertificate(parseCertificate((Element) nodeSimpleCertificate, true));
        } else {
            producer.setCertificate(parseCertificate((Element) nodeLimitedCertificate, false));
        }

        version.setType(Consistence.getEnum(versionElement.getAttribute("type")));
        version.setProducer(producer);

        return version;
    }

    public Dosage parseDosage(Element dosageElement) {
        Dosage dosage = new Dosage();
        dosage.setCount(Integer.parseInt(getChildValue(dosageElement, "count")));
        dosage.setPeriod(Period.getEnum(getChildValue(dosageElement, "period")));

        return dosage;
    }

    public Package parsePackage(Element packageElement) {
        Package aPackage = new Package();
        aPackage.setPrice(Integer.parseInt(getChildValue(packageElement, "price")));
        aPackage.setQuantity(Integer.parseInt(getChildValue(packageElement, "quantity")));
        aPackage.setType(PackageType.getEnum(packageElement.getAttribute("type")));

        return aPackage;
    }

    public Certificate parseCertificate(Element certificateElement, boolean isSimple) {
        Certificate certificate = new Certificate();

        certificate.setNumber(certificateElement.getAttribute("number"));
        certificate.setOrganization(getChildValue(certificateElement, "organization"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date issueDate = formatter.parse(getChildValue(certificateElement, "issue_date"));
            certificate.setIssueDate(issueDate);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }

        return certificate;
    }
}
