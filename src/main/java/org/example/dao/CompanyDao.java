package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionFactoryUtil;
import org.example.dto.CompanyProfitDto;
import org.example.dto.EmployeeDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.entity.NewOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CompanyDao {


//    public static Float getCompanyCapitalBetween(String name, LocalDate startTime, LocalDate endTime) {
//        Float capital;
//        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            capital = session.createQuery(
//                            "select sum(price) from NewOrder n, Company a" +
//                                   // " join fetch n.company c " +
//                                    " inner join fetch n.receipts r" +
//                                    "where Company.name = :name"+
//                                "and n.startTime >= :startTime"+
//                            "and n.endTime <= :endTime",
//                            Float.class)
//                    .setParameter("name", name)
//                    .setParameter("startTime", startTime)
//                    .setParameter("endTime", endTime)
//                    .getSingleResult();
//            transaction.commit();
//        }
//    public static Double getCompanyProfitDto(long id) {
//        Double capital;
//        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
//            Transaction transaction = session.beginTransaction();
//            capital = session.createQuery(" select sum(n.price) from Company c" +
//            " join c.orders n " +
//            " join n.receipts r" +
//            " where r.id is not null and c.id = :id", Double.class).setParameter("id", id).getSingleResult();
//            transaction.commit();
//
//        }
//        return capital;
//    }
//gives the profit of company in dto
public static List<CompanyProfitDto> getCompanyByProfitDto(long id ) {
    List<CompanyProfitDto> companyProfitDTOS;
    try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        StringBuilder queryBuilder = new StringBuilder(" ");

        companyProfitDTOS = session.createQuery(" select new org.example.dto.CompanyProfitDto(c.id, c.name, sum(p.price)) from Company c " +
                       // " join p.company c " +
                        " join c.orders p " +
                        " join p.receipts r" +
                        " where r.id is not null and c.id = :id" +
                        " group by c.id, c.name "
                        , CompanyProfitDto.class)
                .setParameter("id", id)
                .getResultList();
        transaction.commit();
    }
    return companyProfitDTOS;
}


    //gives the profit of company with id in time period
    public static Double getCompanyProfitBetweeen(long id , LocalDate startTime, LocalDate endTime ){
        Double capital;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            capital = session.createQuery(" select sum(n.price) from Company c" +
                            " join c.orders n " +
                            " join n.receipts r" +
                            " where r.id is not null and c.id = :id"+
                            " and n.startTime>=:startTime"+
                            " and n.endTime<=:endTime", Double.class)
                    .setParameter("id", id)
                    .setParameter("startTime", startTime)
                    .setParameter("endTime", endTime)
                    .getSingleResult();
            transaction.commit();

        }
        return capital;
    }
    //gives the profit of company with id
    public static Double getCompanyProfit(long id) {
        Double capital;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            capital = session.createQuery(" select sum(n.price) from Company c" +
                    " join c.orders n " +
                    " join n.receipts r" +
                    " where r.id is not null and c.id = :id", Double.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();

        }
        return capital;
    }
        //Company by name
        public static Company getCompanyByName (String name){
            Company company;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                company = session.get(Company.class, name);
                transaction.commit();
            }
            return company;
        }

        public static List<Company> getCompaniesByName (String name){
            List<Company> companies;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                companies = session.createQuery("Select c From org.example.entity.Company c " +
                        "WHERE name = :name", Company.class)
                        .setParameter("name", name)
                        .getResultList();
                transaction.commit();
            }
            return companies;
        }

        public static List<Company> companiesWithNameLike(String name) {   //check by similar name
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Company> cr = cb.createQuery(Company.class);
                Root<Company> root = cr.from(Company.class);
                cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));

                Query<Company> query = session.createQuery(cr);
                List<Company> companies = query.getResultList();
                return companies;
            }
        }
    public static List<Company> companiesWithNameNotLike(String name) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> cr = cb.createQuery(Company.class);
            Root<Company> root = cr.from(Company.class);
            cr.select(root).where(cb.notLike(root.get("name"), "%" + name + "%"));

            Query<Company> query = session.createQuery(cr);
            List<Company> companies = query.getResultList();
            return companies;
        }
    }


    //Company employees
        public static Set<Employee> getCompanyEmployees ( long id){
            Company company;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                company = session.createQuery("select c from Company c" +
                        " join fetch c.employees" +
                        " where c.id = :id", Company.class)
                        .setParameter("id", id)
                        .getSingleResult();
                transaction.commit();
            }
            return company.getEmployees();
        }

        public static List<EmployeeDto> getCompanyEmployeesDTO ( long id){
            List<EmployeeDto> employees;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                employees = session.createQuery("select new org.example.dto.EmployeeDto(e.id, e.name, e.familyName) from Employee e"
                        + " join e.company c "
                        + "where c.id = :id", EmployeeDto.class)
                        .setParameter("id", id)
                        .getResultList();
                transaction.commit();
            }
            return employees;
        }


        //Crud
        public static void createCompany (Company company){
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(company);
                transaction.commit();
            }
        }

        public static Company getCompanyById ( long id){
            Company company;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                company = session.get(Company.class, id);
                transaction.commit();
            }
            return company;
        }

        public static List<Company> getCompanies () {
            List<Company> companies;
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                companies = session.createQuery("Select c From org.example.entity.Company c", Company.class).getResultList();
                transaction.commit();
            }
            return companies;
        }

        public static void updateCompany (Company company){
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(company);
                transaction.commit();
            }
        }

        public static void deleteCompany (Company company){
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(company);
                transaction.commit();
            }
        }
    }
//Crud


