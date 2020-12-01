package by.training.entity;

import by.training.entity.enumeration.Consistence;

public class Version {
    private Consistence type;
    //TODO multiple producers
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
