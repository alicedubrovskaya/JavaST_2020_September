package by.training.xml.entity;

import java.util.Objects;

public class Producer {
    private Certificate certificate;
    private Package aPackage;
    private Dosage dosage;

    public Producer() {
        aPackage = new Package();
        dosage = new Dosage();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Producer producer = (Producer) o;
        return Objects.equals(certificate, producer.certificate)
                && Objects.equals(aPackage, producer.aPackage)
                && Objects.equals(dosage, producer.dosage);
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
