package org.example.entity;

import jakarta.persistence.*;
import org.example.entity.enumeration.Unit;

import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "type")
    private String type;
    @Enumerated(EnumType.STRING)
    @Column(name = "capacity_unit")
    private Unit unit;
    @Column(name = "capacity")
    private float capacity;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private Set<NewOrder> orders;

    public Vehicle() {
    }

    public Vehicle(long id, String type, Unit unit, float capacity) {
        this.id = id;
        this.type = type;
        this.unit = unit;
        this.capacity = capacity;
    }

    public Vehicle(long id, String type, Unit unit, float capacity, Company company, Set<NewOrder> orders) {
        this.id = id;
        this.type = type;
        this.unit = unit;
        this.capacity = capacity;
        this.company = company;
        this.orders = orders;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", capacityUnit='" + unit + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
