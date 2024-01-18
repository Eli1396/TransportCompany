package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.dao.CompanyDao;

import java.util.Set;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank(message = "Vehicle name cannot be blank!")
    @Size(max = 20, message = "Vehicle name has to be with up to 20 characters!")
    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;
    @Enumerated(EnumType.STRING)
    @Column(name = "payload_type")
    private PayloadType payloadType;
    @Column(name = "capacity", nullable = false)
    private float capacity;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private Unit unit;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private Set<NewOrder> orders;

    public Vehicle() {
    }

    public Vehicle(String vehicleType, PayloadType payloadType, float capacity, Unit unit) {
        this.vehicleType = vehicleType;
        this.payloadType = payloadType;
        this.capacity = capacity;
        this.unit = unit;
    }

    public Vehicle(String vehicleType, PayloadType payloadType, float capacity) {
        this.vehicleType = vehicleType;
        this.payloadType = payloadType;
        this.capacity = capacity;
    }

    public Vehicle(String vehicleType, PayloadType payloadType, float capacity, Unit unit, Company company) {
        this.vehicleType = vehicleType;
        this.payloadType = payloadType;
        this.capacity = capacity;
        this.unit = unit;
        this.company = company;
    }
    public Vehicle(String vehicleType, PayloadType payloadType, float capacity, Unit unit, int company1) {
        Company company = CompanyDao.getCompanyById(company1);
        this.vehicleType = vehicleType;
        this.payloadType = payloadType;
        this.capacity = capacity;
        this.unit = unit;
        this.company = company;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleType='" + vehicleType + '\'' +
                ", payloadType=" + payloadType +
                ", capacity=" + capacity +
                ", unit=" + unit +
                '}';
    }
}
