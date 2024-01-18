package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionFactoryUtil;

import org.example.dto.*;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDao {

    public static List<EmployeeProfitDto> getEmployeeProfit(long id ) {
        List<EmployeeProfitDto> EmployeeProfitDto;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryBuilder = new StringBuilder(" ");

            EmployeeProfitDto = session.createQuery(" select new org.example.dto.EmployeeProfitDto(c.name, c.familyName, sum(p.price)) from Employee c " +
                                    // " join p.company c " +
                                    " join c.orders p " +
                                    " join p.receipts r" +
                                    " where r.id is not null and c.id = :id"
                            , EmployeeProfitDto.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return EmployeeProfitDto;
    }
    public static List<EmployeeOrdersDto> getEmployeeOrders(long id ) {
        List<EmployeeOrdersDto> EmployeeProfitDto;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            StringBuilder queryBuilder = new StringBuilder(" ");

            EmployeeProfitDto = session.createQuery(" select new org.example.dto.EmployeeOrdersDto(c.name, c.familyName, count(p.id)) from Employee c " +
                                    // " join p.company c " +
                                    " join c.orders p " +

                                    " where c.id = :id"
                            , EmployeeOrdersDto.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return EmployeeProfitDto;
    }
    //gets employee's skills
    public static List<SkillDto> getEmployeeSkillsDto (long id){
        List<SkillDto> skills;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            skills = session.createQuery("select new org.example.dto.SkillDto(s.id, s.type) from Skill s"
                            + " join s.employees e "
                            + "where e.id = :id",
                            SkillDto.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return skills;
    }
//gets employee by salary
    public static Employee getEmployeeBySalary(String salary) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, salary);
            transaction.commit();
        }
        return employee;
    }
    public static List<Employee> getEmployeesBySalary(String salary){
        List<Employee> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery("Select c From org.example.entity.Employee c"+
                                    " Where c.salary=:salary"
                            , Employee.class)
                    .setParameter("salary", salary)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }

    public static List<Employee> employeesWithNameLike(String name) {   //check by similar name
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);
            cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

            Query<Employee> query = session.createQuery(cr);
            List<Employee> employees = query.getResultList();
            return employees;
        }
    }
    //Crud
    public static void createEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }
    public static Employee getEmployeeById(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }
    public static List<Employee> getEmployees(){
        List<Employee> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery("Select c From org.example.entity.Employee c", Employee.class)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }
    public static void updateEmployee(Employee employee){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }
    public static void deleteEmployee(Employee employee){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
    //Crud
}
