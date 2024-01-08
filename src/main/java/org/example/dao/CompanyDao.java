package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.EmployeeDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class CompanyDao {


    //Company by name
    public static Company getCompanyByName(String name) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, name);
            transaction.commit();
        }
        return company;
    }
    public static List<Company> getCompaniesByName(String name){
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select c From org.example.entity.Company c "+
                            "WHERE name = :name", Company.class)
                    .setParameter("name",name)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }
    //Company employees
    public static Set<Employee> getCompanyEmployees(long id) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.createQuery(
                            "select c from Company c" +
                                    " join fetch c.employees" +
                                    " where c.id = :id",
                            Company.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return company.getEmployees();
    }

    public static List<EmployeeDto> getCompanyEmployeesDTO(long id) {
        List<EmployeeDto> employees;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery(
                            "select new org.example.dto.EmployeeDto(e.id, e.name) from Employee e" +
                                    " join e.company c " +
                                    "where c.id = :id",
                            EmployeeDto.class)
                    .setParameter("id", id)
                    .getResultList();
            transaction.commit();
        }
        return employees;
    }




    //Crud
    public static void createCompany(Company company) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }
    public static Company getCompanyById(long id) {
        Company company;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            company = session.get(Company.class, id);
            transaction.commit();
        }
        return company;
    }
    public static List<Company> getCompanies(){
        List<Company> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select c From org.example.entity.Company c", Company.class)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }
    public static void updateCompany(Company company){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }
    public static void deleteCompany(Company company){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }
    //Crud

}
