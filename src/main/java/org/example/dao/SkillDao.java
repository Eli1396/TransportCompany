package org.example.dao;

import org.example.configuration.SessionFactoryUtil;

import org.example.dto.EmployeeDto;
import org.example.dto.SkillDto;
import org.example.entity.Employee;
import org.example.entity.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillDao {
    //gets employees by skills
    public static List<EmployeeDto> getEmployeesBySkillDto (String type){
        List<EmployeeDto> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery("select new org.example.dto.EmployeeDto(e.id, e.name, e.familyName)"+
                                    " from Employee e" +
                                    " join e.skills s " +
                                    " where s.type = :type",
                            EmployeeDto.class)
                    .setParameter("type", type)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

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
            skills = session.createQuery("Select c From org.example.entity.Skill c", Skill.class)
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
