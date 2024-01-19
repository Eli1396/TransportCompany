package org.example.entity;

import jakarta.persistence.*;

import static org.example.dao.ClientDao.getClientById;
import static org.example.dao.NewOrderDao.getNewOrderById;

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

    public Receipt( NewOrder newOrder, Client client) {
        this.newOrder = newOrder;
        this.client = client;
    }
    public Receipt( long newOrderId, long clientId) {
        NewOrder newOrder1=getNewOrderById(newOrderId);
        Client client1=getClientById(clientId);
        this.newOrder = newOrder1;
        this.client = client1;
    }

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                '}';
    }
}
