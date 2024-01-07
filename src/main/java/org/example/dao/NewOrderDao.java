package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.NewOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NewOrderDao {
    //Crud
    public static void createNewOrder(NewOrder newOrder) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newOrder);
            transaction.commit();
        }
    }
    public static NewOrder getNewOrderById(long id) {
        NewOrder newOrder;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            newOrder = session.get(NewOrder.class, id);
            transaction.commit();
        }
        return newOrder;
    }
    public static List<NewOrder> getNewOrders(){
        List<NewOrder> newOrders;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            newOrders = session.createQuery("Select c From org.example.entity.Company c", NewOrder.class)
                    .getResultList();
            transaction.commit();
        }
        return newOrders;
    }
    public static void updateNewOrder(NewOrder newOrder){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(newOrder);
            transaction.commit();
        }
    }
    public static void deleteNewOrder(NewOrder newOrder){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(newOrder);
            transaction.commit();
        }
    }
    //Crud
}
