package by.training.parser.stax;

import by.training.entity.*;
import by.training.entity.Package;
import by.training.entity.enumeration.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MedicinesStAXBuilder {
    private List<Medicine> medicines = new ArrayList<>();
    private XMLInputFactory inputFactory;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final Logger logger = LogManager.getLogger(getClass().getName());


    public MedicinesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void buildSetMedicines(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MEDICINE) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            logger.error("StAX parsing error! {}", ex.getMessage());
        } catch (FileNotFoundException ex) {
            logger.error("File {}not found! {}", fileName, ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("Impossible close file {}:{}", fileName, e);
            }
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine medicine = new Medicine();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            medicine.setName(getXMLText(reader));
                            break;
                        case PHARM:
                            medicine.setPharm(getXMLText(reader));
                            break;
                        case GROUP:
                            medicine.setGroup(Group.getEnum(getXMLText(reader)));
                            break;
                        case ANALOG:
                            medicine.addAnalog(getXMLText(reader));
                            break;
                        case VERSIONS:
                            getXMLVersions(reader).forEach(medicine::addToVersionList);
                            break;
                        default:
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MEDICINE) {
                        return medicine;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Medicine");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private List<Version> getXMLVersions(XMLStreamReader reader) throws XMLStreamException {
        List<Version> versions = new ArrayList<>();
        int type;
        String name;
        Version currentVersion = null;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    currentVersion = new Version();
                    currentVersion.setType(Consistence.getEnum(
                            reader.getAttributeValue(null, "type"))
                    );
                    currentVersion.setProducer(getXMLProducer(reader));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.VERSION) {
                        versions.add(currentVersion);
                        currentVersion = null;
                    } else if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.VERSIONS) {
                        return versions;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Versions");
    }

    private Producer getXMLProducer(XMLStreamReader reader) throws XMLStreamException {
        Producer producer = new Producer();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case DOSAGE:
                            producer.setDosage(getXMLDosage(reader));
                            break;
                        case PACKAGE:
                            producer.setaPackage(getXMLPackage(reader));
                            break;
                        case CERTIFICATE:
                            producer.setCertificate(getXMLCertificate(reader, true));
                            break;
                        case LIMITED_CERTIFICATE:
                            producer.setCertificate(getXMLCertificate(reader, false));
                            break;
                        default:
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.PRODUCER) {
                        return producer;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Producer");
    }

    private Dosage getXMLDosage(XMLStreamReader reader) throws XMLStreamException {
        Dosage dosage = new Dosage();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case COUNT:
                            dosage.setCount(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PERIOD:
                            dosage.setPeriod(Period.getEnum(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.DOSAGE) {
                        return dosage;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Dosage");
    }

    private Package getXMLPackage(XMLStreamReader reader) throws XMLStreamException {
        Package aPackage = new Package();
        aPackage.setType(PackageType.getEnum(
                reader.getAttributeValue(null, "type"))
        );
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case PRICE:
                            aPackage.setPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                        case QUANTITY:
                            aPackage.setQuantity(Integer.parseInt(getXMLText(reader)));
                            break;
                        default:
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.PACKAGE) {
                        return aPackage;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Dosage");
    }

    private Certificate getXMLCertificate(XMLStreamReader reader, boolean isBase) throws XMLStreamException {
        Certificate certificate;
        if (isBase) {
            certificate = new Certificate();
        } else {
            certificate = new LimitedCertificate();
        }

        certificate.setNumber(reader.getAttributeValue(null, "number"));
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case ISSUE_DATE:
                            try {
                                certificate.setIssueDate(formatter.parse(getXMLText(reader)));
                            } catch (ParseException e) {
                                logger.error(e.getMessage());
                            }
                            break;
                        case ORGANIZATION:
                            certificate.setOrganization(getXMLText(reader));
                            break;
                        case EXPIRATION_DATE:
                            try {
                                ((LimitedCertificate) certificate).
                                        setExpirationDate(
                                                formatter.parse(getXMLText(reader))
                                        );
                            } catch (ParseException e) {
                                logger.error(e.getMessage());
                            }
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.CERTIFICATE
                            || MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.LIMITED_CERTIFICATE) {
                        return certificate;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Certificate");
    }
}