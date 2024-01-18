package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Receipt;
import org.example.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReceiptDao {
    //Crud
    public static void createReceipt(Receipt receipt) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(receipt);
            transaction.commit();
        }
    }
    public static void updateReceipt(Receipt receipt){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(receipt);
            transaction.commit();
        }
    }
    public static List<Receipt> getReceipts() {
        List<Receipt> receipts;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            receipts = session.createQuery("Select c From org.example.entity.Receipt c", Receipt.class)
                    .getResultList();
            transaction.commit();
        }
        return receipts;
    }
    //Crud
}
