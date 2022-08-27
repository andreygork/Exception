package ru.netology.domain;
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.manufacturer.equalsIgnoreCase(search)) {
            return true;
        } else {
            return false;
        }
    }
}
