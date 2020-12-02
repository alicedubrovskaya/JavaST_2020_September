package by.training.xml.entity;

public class Producer {
    private Certificate certificate;
    private Package aPackage;
    private Dosage dosage;

    public Producer() {
        aPackage = new Package();
        dosage = new Dosage();
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public Dosage getDosage() {
        return dosage;
    }


}
