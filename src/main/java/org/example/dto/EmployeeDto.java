package org.example.dto;


public class EmployeeDto {

    private long id;
    private String name;
    private String familyName;
    private String salary;

    public EmployeeDto(long id, String name, String familyName, String salary) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
