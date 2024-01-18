package org.example.dto;

public class EmployeeOrdersDto {

    private String name;
    private String familyName;
    private long id;

    public EmployeeOrdersDto(String name, String familyName, long id) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeOrdersDto{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", totalOrders=" + id +
                '}';
    }
}
