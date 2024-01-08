package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.CompanyDao;
import org.example.dao.EmployeeDao;
import org.example.dao.VehicleDao;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.entity.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SessionFactoryUtil.getSessionFactory().openSession();
        Company company = new Company("travelSpeed");
       // Employee employee = new Employee("Asen", "Dimov", "2500");
        Vehicle vehicle = new Vehicle();
        CompanyDao.createCompany(company);
        //EmployeeDao.createEmpoyee(employee);
        vehicle.setId(2);
        VehicleDao.deleteVehicle(vehicle);
        System.out.println("getCompaniesByName:");
        CompanyDao.getCompaniesByName("SAP").stream().forEach(System.out::println);
    }
}