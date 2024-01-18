package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.dao.CompanyDao;

import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @NotBlank(message = "Employee name cannot be blank!")
    @Size(max = 20, message = "Employee name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee name has to start with capital letter!")
    @Column(name="name",nullable = false)
    private String name;
    @NotBlank(message = "Employee family name cannot be blank!")
    @Size(max = 20, message = "Employee family name has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee family name has to start with capital letter!")
    @Column(name="family_name",nullable = false)
    private String familyName;
    @Column(name="salary")
    private String salary;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "employee")
    private Set<NewOrder> orders;

    @ManyToMany(mappedBy = "employees")
    private Set<Skill> skills;

    //

    public Employee() {
    }

    public Employee(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public Employee(String name, String familyName, String salary) {
        this.name = name;
        this.familyName = familyName;
        this.salary = salary;
    }

    public Employee( String name, String familyName, String salary, Company company, Set<NewOrder> orders, Set<Skill> skills) {
        this.name = name;
        this.familyName = familyName;
        this.salary = salary;
        this.company = company;
        this.orders = orders;
        this.skills = skills;
    }

    public Employee(String name, String familyName, String salary, Company company) {
        this.name = name;
        this.familyName = familyName;
        this.salary = salary;
        this.company = company;
    }
    public Employee(String name, String familyName, String salary, long company1) {
        Company company = CompanyDao.getCompanyById(company1);
        this.name = name;
        this.familyName = familyName;
        this.salary = salary;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<NewOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<NewOrder> orders) {
        this.orders = orders;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
