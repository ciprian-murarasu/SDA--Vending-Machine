package model;

public class Product {
    private int code;
    private String name;
    private int price;
    private String size;

    public Product(int cod, String name, int price, String size) {
        this.code = cod;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
