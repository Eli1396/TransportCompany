package org.example.dto;

public class EmployeeProfitDto {
    private String name;
    private String familyName;
    private double price;

    public EmployeeProfitDto(String name, String familyName, double price) {
        this.name = name;
        this.familyName = familyName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "EmployeeProfitDto{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", price=" + price +
                '}';
    }
}
