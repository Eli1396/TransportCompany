package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    //Crud
    public static void createClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }
    public static Client getClientById(long id) {
        Client client;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }
    public static List<Client> getClients(){
        List<Client> clients;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients = session.createQuery("Select c From org.example.entity.Company c", Client.class)
                    .getResultList();
            transaction.commit();
        }
        return clients;
    }
    public static void updateClient(Client client){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }
    public static void deleteCompany(Client client){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
    //Crud
}
