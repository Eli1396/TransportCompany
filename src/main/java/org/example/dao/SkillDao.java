package org.example.dao;

import org.example.configuration.SessionFactoryUtil;

import org.example.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillDao {
    //Crud
    public static void createSkill(Skill skill) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(skill);
            transaction.commit();
        }
    }
    public static Skill getSkillById(long id) {
        Skill skill;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skill = session.get(Skill.class, id);
            transaction.commit();
        }
        return skill;
    }
    public static List<Skill> getSkills(){
        List<Skill> skills;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skills = session.createQuery("Select c From org.example.entity.Company c", Skill.class)
                    .getResultList();
            transaction.commit();
        }
        return skills;
    }
    public static void updateSkill(Skill skill){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(skill);
            transaction.commit();
        }
    }
    public static void deleteSkill(Skill skill){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(skill);
            transaction.commit();
        }
    }
    //Crud
}
