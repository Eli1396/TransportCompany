package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    //Relationships

    @ManyToOne(fetch = FetchType.LAZY)
    private NewOrder newOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Receipt() {
    }

    public long getId() {
        return id;
    }

    public Receipt(long id, NewOrder newOrder, Client client) {
        this.id = id;
        this.newOrder = newOrder;
        this.client = client;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NewOrder getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(NewOrder newOrder) {
        this.newOrder = newOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
