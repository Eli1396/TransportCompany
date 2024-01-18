package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.dao.VehicleDao;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "new_order")
public class NewOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="arrival_point", nullable = false)
    private String arrivalPoint;
    @Column(name="departure_point", nullable = false)
    private String departurePoint;
    @Column(name="price", nullable = false)
    private float price;
    @FutureOrPresent(message = "Begin date cannot be in the past!")
    @Column(name="start_time")
    private LocalDate startTime;
    @FutureOrPresent(message = "End date cannot be in the past!")
    @Column(name="end_time")
    private LocalDate endTime;
    @Column(name="skill_required", nullable = false)
    private String skillRequired;
    @Column(name="typeOfPayload", nullable = false)
    private String typeOfPayload;
    @Column(name="payload_weight")
    private int payloadWeight;


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

    public NewOrder(String arrivalPoint, String departurePoint, float price, LocalDate startTime,
                    LocalDate endTime, String skillRequired, String typeOfPayload) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
    }

    public NewOrder(String arrivalPoint, String departurePoint, float price, LocalDate startTime,
                    LocalDate endTime, String skillRequired, String typeOfPayload, int payloadWeight) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.payloadWeight = payloadWeight;
    }

    public NewOrder(String arrivalPoint, String departurePoint, float price, LocalDate startTime,
                    LocalDate endTime, String skillRequired, String typeOfPayload, int payloadWeight,
                    Employee employee, Company company, Vehicle vehicle) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.payloadWeight = payloadWeight;
        this.employee = employee;
        this.company = company;
        this.vehicle = vehicle;
    }

    public NewOrder(String arrivalPoint, String departurePoint, float price, LocalDate startTime,
                    LocalDate endTime, String skillRequired, String typeOfPayload, Employee employee,
                    Company company, Vehicle vehicle) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.employee = employee;
        this.company = company;
        this.vehicle = vehicle;
    }
    public NewOrder(String arrivalPoint, String departurePoint, float price, LocalDate startTime,
                    LocalDate endTime, String skillRequired, String typeOfPayload, Company company) {
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.company = company;
    }

    public NewOrder( String arrivalPoint, String departurePoint,
                    float price, LocalDate startTime, LocalDate endTime,
                    String skillRequired, String typeOfPayload, int payloadWeight,
                    long employee, long company, long vehicle) {
        Employee employee1 = EmployeeDao.getEmployeeById(employee);
        Company company1 = CompanyDao.getCompanyById(company);
        Vehicle vehicle1 = VehicleDao.getVehicleById(vehicle);
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.payloadWeight = payloadWeight;
        this.employee = employee1;
        this.company = company1;
        this.vehicle = vehicle1;
    }
    public NewOrder( String arrivalPoint, String departurePoint,
                     float price, LocalDate startTime, LocalDate endTime,
                     String skillRequired, String typeOfPayload,
                     long employee, long company, long vehicle) {
        Employee employee1 = EmployeeDao.getEmployeeById(employee);
        Company company1 = CompanyDao.getCompanyById(company);
        Vehicle vehicle1 = VehicleDao.getVehicleById(vehicle);
        this.arrivalPoint = arrivalPoint;
        this.departurePoint = departurePoint;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skillRequired = skillRequired;
        this.typeOfPayload = typeOfPayload;
        this.employee = employee1;
        this.company = company1;
        this.vehicle = vehicle1;
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

    public String getSkillRequired() {
        return skillRequired;
    }

    public void setSkillRequired(String skillRequired) {
        this.skillRequired = skillRequired;
    }

    public String getTypeOfPayload() {
        return typeOfPayload;
    }

    public void setTypeOfPayload(String typeOfPayload) {
        this.typeOfPayload = typeOfPayload;
    }

    public int getPayloadWeight() {
        return payloadWeight;
    }

    public void setPayloadWeight(int payloadWeight) {
        this.payloadWeight = payloadWeight;
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

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
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
                ", skillRequired='" + skillRequired + '\'' +
                ", typeOfPayload='" + typeOfPayload + '\'' +
                ", payloadWeight=" + payloadWeight +
                '}';
    }
}
