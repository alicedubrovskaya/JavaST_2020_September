package by.training.xml.entity;


import by.training.xml.entity.enumeration.Consistence;

public class Version {
    private Consistence type;
    private Producer producer;

    public Version() {
    }

    public void setType(Consistence type) {
        this.type = type;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Consistence getType() {
        return type;
    }

    public Producer getProducer() {
        return producer;
    }

}
