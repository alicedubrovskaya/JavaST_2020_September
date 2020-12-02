package by.training.xml.entity;


import by.training.xml.entity.enumeration.PackageType;

public class Package {
    private PackageType type;
    private int quantity;
    private int price;

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
