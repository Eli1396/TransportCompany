package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="type")
    private String type;

    //Relationships

    @ManyToMany
    private Set<Employee> employees;

    public Skill() {
    }

    public Skill(String type) {
        this.type = type;
    }

    public Skill(long id, String type, Set<Employee> employees) {
        this.id = id;
        this.type = type;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
