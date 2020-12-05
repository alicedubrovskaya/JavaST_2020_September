package by.training.xml.parser.sax;

import by.training.xml.entity.*;
import by.training.xml.entity.Package;
import by.training.xml.entity.enumeration.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

public class MedicineHandler extends DefaultHandler {
    private List<Medicine> medicines;
    private EnumSet<MedicineEnum> withText;
    private MedicineEnum currentEnum = null;
    private Medicine currentMedicine = null;
    private Version currentVersion = null;
    private Producer currentProducer = null;
    private Package currentPackage = null;
    private Certificate currentCertificate;

    private final Logger logger = LogManager.getLogger(getClass().getName());
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public MedicineHandler() {
        medicines = new ArrayList<>();
        withText = EnumSet.range(MedicineEnum.MEDICINES, MedicineEnum.PERIOD);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startDocument() throws SAXException {
        logger.info("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        MedicineEnum temp = MedicineEnum.valueOf(localName.toUpperCase());
        logger.debug("Current starting element is: {}", localName.toUpperCase());
        switch (temp) {
            case MEDICINE:
                currentMedicine = new Medicine();
                break;
            case VERSION:
                currentVersion = new Version();
                String type = attrs.getValue("type");
                currentVersion.setType(Consistence.getEnum(type));
                break;
            case PRODUCER:
                currentProducer = new Producer();
                break;
            case CERTIFICATE:
                currentCertificate = new Certificate();
                currentCertificate.setNumber(attrs.getValue("number"));
                break;
            case LIMITED_CERTIFICATE:
                currentCertificate = new LimitedCertificate();
                currentCertificate.setNumber(attrs.getValue("number"));
                break;
            case PACKAGE:
                currentPackage = new Package();
                currentPackage.setType(PackageType.getEnum(attrs.getValue("type")));
                break;
        }
        if (!"medicine".equals(localName) && withText.contains(temp)) {
            currentEnum = temp;
        }
    }


    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            logger.debug("Current enum: {}", currentEnum.toString());
            switch (currentEnum) {
                case NAME:
                    currentMedicine.setName(s);
                    break;
                case PHARM:
                    currentMedicine.setPharm(s);
                    break;
                case ANALOG:
                    currentMedicine.addAnalog(s);
                    break;
                case GROUP:
                    currentMedicine.setGroup(Group.getEnum(s));
                    break;

                case CONSISTENCE:
                    currentVersion.setType(Consistence.getEnum(s));
                    break;

                case EXPIRATION_DATE:

                    try {
                        Date expirationDate = formatter.parse(s);
                        ((LimitedCertificate) currentCertificate).setExpirationDate(expirationDate);
                    } catch (ParseException e) {
                        logger.error(e.getMessage());
                    }
                    break;
                case ORGANIZATION:
                    currentCertificate
                            .setOrganization(s);
                    break;
                case ISSUE_DATE:
                    try {
                        Date issueDate = formatter.parse(s);
                        currentCertificate.setIssueDate(issueDate);
                    } catch (ParseException e) {
                        logger.error(e.getMessage());
                    }
                    break;

                case QUANTITY:
                    currentPackage
                            .setQuantity(Integer.parseInt(s));
                    break;
                case PRICE:
                   currentPackage
                            .setPrice(Integer.parseInt(s));
                    break;

                case COUNT:
                    currentProducer.
                            getDosage().
                            setCount(Integer.parseInt(s));
                    break;
                case PERIOD:
                    currentProducer
                            .getDosage()
                            .setPeriod(Period.getEnum(s));
                    break;
                default:
            }
        }
        currentEnum = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MedicineEnum temp = MedicineEnum.valueOf(localName.toUpperCase());
        logger.debug("Ending element : {}", temp.toString());
        switch (temp) {
            case MEDICINE:
                medicines.add(currentMedicine);
                currentMedicine = null;
                break;
            case VERSION:
                currentMedicine.addToVersionList(currentVersion);
                currentVersion = null;
                break;
            case PRODUCER:
                currentVersion.setProducer(currentProducer);
                currentProducer = null;
                break;
            case CERTIFICATE:
                currentProducer.setCertificate(currentCertificate);
                currentCertificate = null;
                break;
            case LIMITED_CERTIFICATE:
                currentProducer.setCertificate(currentCertificate);
                currentCertificate = null;
                break;
            case PACKAGE:
                currentProducer.setaPackage(currentPackage);
                currentPackage = null;
                break;
            default:
                break;
        }
    }
}
