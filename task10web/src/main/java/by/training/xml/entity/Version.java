package by.training.xml.entity;


import by.training.xml.entity.enumeration.Consistence;

import java.util.Objects;

public class Version {
    private Consistence type;
    private Producer producer;

    public Version() {
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Version version = (Version) o;
        return Objects.equals(type, version.type)
                && Objects.equals(producer, version.producer);
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
