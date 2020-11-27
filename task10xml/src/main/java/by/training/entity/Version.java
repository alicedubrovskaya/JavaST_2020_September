package by.training.entity;

import by.training.entity.enumeration.Consistence;

public class Version {
    private Consistence type;
    private Producer producer;

    public void setType(Consistence type) {
        this.type = type;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
