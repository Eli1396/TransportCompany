package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.NewOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NewOrderDao {
    public static Double sumNewOrdersProfit(){
        Double newOrders;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            newOrders = session.createQuery("Select sum(n.price) From org.example.entity.NewOrder n "
                            , Double.class)
                    .getSingleResult();
            transaction.commit();
        }
        return newOrders;
    }
    public static Long sumNewOrders(){
        Long newOrders;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            newOrders = session.createQuery("Select count(n.id) From org.example.entity.NewOrder n "
                            , Long.class)
                    .getSingleResult();
            transaction.commit();
        }
        return newOrders;
    }

    //order by destination
    public static List<NewOrder> getNewOrdersByDestination(String arrivalPoint){
        List<NewOrder> newOrders;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            newOrders = session.createQuery("Select n From org.example.entity.NewOrder n "+
                            "WHERE arrivalPoint = :arrivalPoint", NewOrder.class)
                    .setParameter("arrivalPoint",arrivalPoint)
                    .getResultList();
            transaction.commit();
        }
        return newOrders;
    }

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
            newOrders = session.createQuery("Select c From org.example.entity.NewOrder c", NewOrder.class)
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
