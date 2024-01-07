package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "new_order")
public class NewOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="arrival_point")
    private String arrivalPoint;
    @Column(name="departure_point")
    private String departurePoint;
    @Column(name="price")
    private float price;
    @Column(name="start_time")
    private LocalDate startTime;
    @Column(name="end_time")
    private LocalDate endTime;
    @Column(name="skill_required")
    private int skillRequired;
    @Column(name="type_of_payload")
    private int typeOfPayload;
    @Column(name="weight")
    private int weight;


    //Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "newOrder")
    private Set<Receipt> receipts;

    //


    public NewOrder() {
    }


    public NewOrder( String arrivalPoint, String departurePoint,
                    float price, LocalDate startTime, LocalDate endTime, int skillRequired, int typeOfPayload) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
    }

    public NewOrder( String arrivalPoint, String departurePoint,
                    float price, LocalDate startTime, LocalDate endTime, int skillRequired, int typeOfPayload, int weight) {

        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "id=" + id +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", departurePoint='" + departurePoint + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", skillRequired=" + skillRequired +
                ", typeOfPayload=" + typeOfPayload +
                ", weight=" + weight +
                '}';
    }

    public NewOrder(long id, String arrivalPoint, String departurePoint,
                    float price, LocalDate startTime, LocalDate endTime, int skillRequired,
                    int typeOfPayload, int weight, Employee employee, Company company, Vehicle vehicle, Set<Receipt> receipts) {
        this.id = id;
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.weight = weight;
        this.employee = employee;
        this.company = company;
        this.vehicle = vehicle;
        this.receipts = receipts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public int getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(int skillRequired) {
        this.skillRequired = skillRequired;
    }

    public int getTypeOfPayload() {
        return typeOfPayload;
    }

    public void setTypeOfPayload(int typeOfPayload) {
        this.typeOfPayload = typeOfPayload;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
