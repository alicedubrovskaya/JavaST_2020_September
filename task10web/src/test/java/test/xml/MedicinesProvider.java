package test.xml;

import by.training.xml.entity.Certificate;
import by.training.xml.entity.Medicine;
import by.training.xml.entity.Producer;
import by.training.xml.entity.Version;
import by.training.xml.entity.enumeration.Consistence;
import by.training.xml.entity.enumeration.Group;
import by.training.xml.entity.enumeration.PackageType;
import by.training.xml.entity.enumeration.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicinesProvider {

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public List<Medicine> createDataOne() {
        List<Medicine> medicines = new ArrayList<>();
        Medicine medicine = new Medicine();
        Producer producer = new Producer();
        Version version = new Version();
        Certificate certificate = new Certificate();

        medicine.setName("Кардиомагнил");
        medicine.setPharm("Такеда ГмбХ");
        medicine.setGroup(Group.VITAMINS);
        medicine.addAnalog("Магнекард");
        medicine.addAnalog("Полокард");

        try {
            Date issueDate = formatter.parse("2008-03-22");
            certificate.setIssueDate(issueDate);
        } catch (
                ParseException e) {
            System.err.println(e.getMessage());
        }
        certificate.setNumber("ЛСР-009047/20");
        certificate.setOrganization("Acard");

        producer.getaPackage().setPrice(10);
        producer.getaPackage().setQuantity(2);
        producer.getaPackage().setType(PackageType.BLISTER_PACKAGING);

        producer.getDosage().setCount(4);
        producer.getDosage().setPeriod(Period.DAY);

        producer.setCertificate(certificate);
        version.setType(Consistence.TABLETS);
        version.setProducer(producer);
        medicine.addToVersionList(version);
        medicines.add(medicine);
        return medicines;
    }

    public List<Medicine> createDataTwo() {
        List<Medicine> medicines = new ArrayList<>();
        Medicine medicine = new Medicine();
        Producer producer = new Producer();
        Version version = new Version();
        Certificate certificate = new Certificate();

        medicine.setName("Парацетамол");
        medicine.setPharm("Ирбитский химфармзавод ОАО");
        medicine.setGroup(Group.ANTIBIOTICS);
        medicine.addAnalog("Тайленол");
        medicine.addAnalog("Апап");

        try {
            Date issueDate = formatter.parse("2019-03-22");
            certificate.setIssueDate(issueDate);
        } catch (
                ParseException e) {
            System.err.println(e.getMessage());
        }
        certificate.setNumber("ЛСР-009047/08");
        certificate.setOrganization("BelMedicines");

        producer.getaPackage().setPrice(100);
        producer.getaPackage().setQuantity(10);
        producer.getaPackage().setType(PackageType.BLISTER_PACKAGING);

        producer.getDosage().setCount(3);
        producer.getDosage().setPeriod(Period.DAY);

        producer.setCertificate(certificate);
        version.setType(Consistence.TABLETS);
        version.setProducer(producer);
        medicine.addToVersionList(version);
        medicines.add(medicine);
        return medicines;
    }

    public List<Medicine> createDataThree() {
        List<Medicine> medicines = new ArrayList<>();
        Medicine medicine = new Medicine();
        Producer producer = new Producer();
        Version version = new Version();
        Certificate certificate = new Certificate();

        medicine.setName("Вильпрафенум");
        medicine.setPharm("Такеда ГмбХ");
        medicine.setGroup(Group.ANTIBIOTICS);
        medicine.addAnalog("Вильпрафен солютаб");
        medicine.addAnalog("Супракс солютаб");

        try {
            Date issueDate = formatter.parse("2008-03-22");
            certificate.setIssueDate(issueDate);
        } catch (
                ParseException e) {
            System.err.println(e.getMessage());
        }
        certificate.setNumber("ЛСР-009047/20");
        certificate.setOrganization("БЕЛМЕДПРЕПАРАТЫ");

        producer.getaPackage().setPrice(250);
        producer.getaPackage().setQuantity(2);
        producer.getaPackage().setType(PackageType.CONTOURE_CELLESS);

        producer.getDosage().setCount(1);
        producer.getDosage().setPeriod(Period.MONTH);

        producer.setCertificate(certificate);
        version.setType(Consistence.CAPSULES);
        version.setProducer(producer);
        medicine.addToVersionList(version);
        medicines.add(medicine);
        return medicines;
    }
}
