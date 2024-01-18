package org.example.dto;

public class CompanyProfitDto {
    private long id;
    private String name;
    private double price;

    public CompanyProfitDto(long id) {
        this.id = id;
    }

    public CompanyProfitDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyProfitDto(String name) {
        this.name = name;
    }

    public CompanyProfitDto(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CompanyProfitDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
