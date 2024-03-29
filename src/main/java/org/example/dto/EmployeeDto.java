package org.example.dto;


public class EmployeeDto {

    private long id;
    private String name;
    private String familyName;

    public EmployeeDto(long id, String name, String familyName) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
