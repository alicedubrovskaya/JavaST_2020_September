package by.training.xml.entity;


import by.training.xml.entity.enumeration.PackageType;
import by.training.xml.entity.list.VersionList;

import java.util.Objects;

public class Package {
    private PackageType type;
    private int quantity;
    private int price;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Package aPackage = (Package) o;
        return Objects.equals(type, aPackage.type)
                && quantity == aPackage.quantity
                && price == aPackage.price;
    }

    public void setType(PackageType type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PackageType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
