package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.dto.CompanyDto;
import org.example.dto.CompanyProfitDto;
import org.example.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.example.entity.PayloadType.CARGO;
import static org.example.entity.PayloadType.HUMAN;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SessionFactoryUtil.getSessionFactory().openSession();
/*
        Skill skill1 = new Skill( "C");
        Skill skill2 = new Skill( "DE");
        Skill skill3 = new Skill( "Every");
        Skill skill4 = new Skill( "C1E");
        Skill skill5 = new Skill( "CE");
        SkillDao.createSkill(skill1);
        SkillDao.createSkill(skill2);
        SkillDao.createSkill(skill3);
        SkillDao.createSkill(skill4);
        SkillDao.createSkill(skill5);

        Vehicle vehicle1 = new Vehicle("truck", CARGO,3000, Unit.KILOGRAMS,1);
        Vehicle vehicle2 = new Vehicle("bus", HUMAN,12, Unit.PEOPLE);
        Vehicle vehicle3 = new Vehicle("tank truck", CARGO,4000, Unit.LITERS);
        Vehicle vehicle4 = new Vehicle("van", CARGO,1500, Unit.KILOGRAMS);
        VehicleDao.createVehicle(vehicle1);
        VehicleDao.createVehicle(vehicle2);
        VehicleDao.createVehicle(vehicle3);
        VehicleDao.createVehicle(vehicle4);

        Company company1 = new Company("TRR");
        Company company2 = new Company("Transo");
        Company company3 = new Company("Speed");
        Company company4 = new Company("DeliveryToday");
        Company company5 = new Company("SafeTravel");
        CompanyDao.createCompany(company1);
        CompanyDao.createCompany(company2);
        CompanyDao.createCompany(company3);
        CompanyDao.createCompany(company4);
        CompanyDao.createCompany(company5);

        Client client1 = new Client( "Klient", "Klientov");
        Client client2 = new Client( "Metodi", "Klientov");
        Client client3 = new Client( "Krum", "Stoyanov");
        Client client4 = new Client( "Vasil", "Terziev");
        ClientDao.createClient(client1);
        ClientDao.createClient(client2);
        ClientDao.createClient(client3);
        ClientDao.createClient(client4);

        Employee employee1 = new Employee("Asen", "Petrov", "3500.00",1);
        Employee employee2 = new Employee("Milen", "Dimov", "2350.00",1);
        Employee employee3 = new Employee("Stefan", "Davidov", "2500.00",2);
        Employee employee4 = new Employee("Monica", "Lilova", "1500.00",3);
        EmployeeDao.createEmployee(employee1);
        EmployeeDao.createEmployee(employee2);
        EmployeeDao.createEmployee(employee3);
        EmployeeDao.createEmployee(employee4);

        NewOrder newOrder1 = new NewOrder("Varna", "Sofia",40,
                        LocalDate.of(2024,04,10), LocalDate.of(2024,04,12),
                     "Category D","Furniture",250,1,1,1 );
        NewOrder newOrder2 = new NewOrder("Burgas", "Sofia",50,
                LocalDate.of(2024,03,11), LocalDate.of(2024,03,12),
                "Category CE","Books",470 ,1,1,1);
        NewOrder newOrder3 = new NewOrder("Vidin", "Lovech",40,
                LocalDate.of(2024,02,05), LocalDate.of(2024,02,13),
                "Category DE","Person" ,1,1,1);
        NewOrder newOrder4 = new NewOrder("Stara Zagora", "Pleven",70,
                LocalDate.of(2024,02,10), LocalDate.of(2024,02,12),
                "Category D","Shipments",360 ,1,1,1);
        NewOrderDao.createNewOrder(newOrder1);
        NewOrderDao.createNewOrder(newOrder2);
        NewOrderDao.createNewOrder(newOrder3);
        NewOrderDao.createNewOrder(newOrder4);


//        Receipt receipt1 = new Receipt( newOrder1,client1);
//        Receipt receipt2 = new Receipt( newOrder2,client2);
//        Receipt receipt3 = new Receipt( newOrder3,client2);
//        ReceiptDao.createReceipt(receipt1);
//        ReceiptDao.createReceipt(receipt2);
//        ReceiptDao.createReceipt(receipt3);


        Company company = new Company("TravelFar");
        company.setId(4);
        CompanyDao.updateCompany(company);
        company.setId(3);
        //CompanyDao.deleteCompany(companyd);

        Client client = new Client( "Ivan", "Benkov");
        client.setId(3);
        ClientDao.updateClient(client);
        client.setId(2);
        //ClientDao.updateClient(client);

        Vehicle vehicle = new Vehicle("tank truck", CARGO,10000, Unit.LITERS);
        vehicle.setId(3);
        VehicleDao.updateVehicle(vehicle);
        vehicle.setId(4);
        //VehicleDao.deleteVehicle(vehicle);

        Employee employee = new Employee("Asen", "Dimov", "2500");
        employee.setId(1);
        EmployeeDao.updateEmployee(employee);
        employee.setId(4);
        //EmployeeDao.deleteEmployee(employee);

        Receipt receipt = new Receipt(1,2);
        ReceiptDao.createReceipt(receipt);
        Receipt receipt1 = new Receipt(2,1);
        ReceiptDao.createReceipt(receipt1);

        CompanyDao.getCompanies().stream().forEach(System.out::println);
        EmployeeDao.getEmployees().stream().forEach(System.out::println);
        VehicleDao.getVehicles().stream().forEach(System.out::println);
        ClientDao.getClients().stream().forEach(System.out::println);
        ReceiptDao.getReceipts().stream().forEach(System.out::println);
        NewOrderDao.getNewOrders().stream().forEach(System.out::println);
        SkillDao.getSkills().stream().forEach(System.out::println);



        System.out.println("Show all companies with name TRR: ");
        CompanyDao.getCompaniesByName("TRR").stream().forEach(System.out::println);

        System.out.println("Show client with id 2: ");
        System.out.println(ClientDao.getClientById(2));

        System.out.println("Show company's employees: ");

        //  Get company's employees using JOIN FETCH
        CompanyDao.getCompanyEmployees(1)
                .stream()
                .forEach(System.out::println);


         //Get company's employees using DTO Projection
        CompanyDao.getCompanyEmployeesDTO(1)
                .stream()
                .forEach(System.out::println);

        System.out.println("Show company's profit in time interval: ");
        Double capital = CompanyDao.getCompanyProfitBetweeen(1,
                LocalDate.of(2024,01,10),
                LocalDate.of(2024,05,12));
        System.out.println(capital);

        System.out.println("Show company's profit : ");
        CompanyDao.getCompanyByProfitDto(1)
                .stream()
               .forEach(System.out::println);

        //Get employee by salary
        System.out.println("Employees whit the salary 2000: ");
        EmployeeDao.getEmployeesBySalary("2000")
                .stream()
                .forEach(System.out::println);

        //Get employee's skills using DTO Projection
        System.out.println("Employee has the following skills: ");
        EmployeeDao.getEmployeeSkillsDto(1)
                .stream()
                .forEach(System.out::println);

        //Get all employees with sertain skill using DTO Projection
        System.out.println("Employees, that have the following skill: ");
        SkillDao.getEmployeesBySkillDto("D")
                .stream()
                .forEach(System.out::println);

        //Get order by destination
        System.out.println("Orders, that have the following destination: ");
        NewOrderDao.getNewOrdersByDestination("Varna")
                .stream()
                .forEach(System.out::println);

        //sum orders
        System.out.println("Sum of all orders: ");
        System.out.println(NewOrderDao.sumNewOrders());

        //sum orders total profit
        System.out.println("Total sum of all orders profit: ");
        System.out.println(NewOrderDao.sumNewOrdersProfit());

        //show employee and the number of orders
        System.out.println("Show employee and the number of orders he has had: ");
        EmployeeDao.getEmployeeOrders(1)
                .stream()
                .forEach(System.out::println);

        //show employee and his profit to the company
        System.out.println("Show employee and his profit to the company: ");
        EmployeeDao.getEmployeeProfit(1)
                .stream()
                .forEach(System.out::println);
*/
//
        //NewOrder newOrder = new NewOrder("Varna", "Sofia",40,
        //        LocalDate.of(2024,01,10), LocalDate.of(2024,01,12),
         //       "Category D","Furniture",250, employee, company, vehicle );
        //NewOrderDao.createNewOrder(newOrder);
        //Receipt receipt = new Receipt(1,1);
        //ReceiptDao.createReceipt(receipt);
        //List<CompanyProfitDto> capital=CompanyDao.getCompanyProfitDto(1);
       // System.out.println(capital);
        //Double capital = CompanyDao.getCompanyProfit(1);
       // System.out.println(capital);
       // NewOrderDao.getNewOrderById(1);
        //System.out.println();
       // CompanyDao.getCompanyProfitDto(1).stream().forEach(System.out::println);
//        Double capital = CompanyDao.getCompanyProfitBetweeen(1,LocalDate.of(2024,01,10), LocalDate.of(2024,01,12));
//         System.out.println(capital);
//        company = CompanyDao.getCompanyById(1);
//        System.out.println(company);


//        //Get employee's skills using DTO Projection
//        System.out.println("Employee has the following skills: ");
//        EmployeeDao.getEmployeeSkillsDto(1)
//                .stream()
//                .forEach(System.out::println);
//        //Get all employees with skill using DTO Projection
//
//        System.out.println("Employees, that have the following skill: ");
//        SkillDao.getEmployeesBySkillDto("D")
//                .stream()
//                .forEach(System.out::println);
//        System.out.println("list: ");
//       // System.out.println(CompanyDao.getCompanyByProfit(1).toString());
//        CompanyDao.getCompanyByProfit(1)
//                .stream()
//               .forEach(System.out::println);;

    }
}