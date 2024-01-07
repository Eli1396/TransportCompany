package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="family_name")
    private String familyName;

    //Relationships

    @OneToMany(mappedBy = "client")
    private Set<Receipt> receipts;

    @ManyToMany
    private Set<Company> companies;

    //

    public Client() {
    }

    public Client(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public Client(long id, String name, String familyName, Set<Receipt> receipts, Set<Company> companies) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.receipts = receipts;
        this.companies = companies;
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

    public Set<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
