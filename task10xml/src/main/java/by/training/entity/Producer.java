package by.training.entity;

public class Producer {
    private Certificate certificate;
    private Package aPackage;
    private Dosage dosage;

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }
}
