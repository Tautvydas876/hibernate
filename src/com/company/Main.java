package com.company;

import com.company.DAO.AirportDAO;
import com.company.DAO.EmployeeDAO;
import com.company.entity.Airport;
import com.company.entity.Employee;
import com.company.utils.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        AirportDAO airportDAO = new AirportDAO();


        Employee employee = new Employee("Kevinas", "Durantas", 7500);
        Employee employee1 = new Employee("Gitanas", "Nauseda", 7500);
        Airport airport = new Airport("Kauno oro uostas", "Kauno g.", "Kaunas");

        //3.2 pridejimas
//        airportDAO.insert(airport);
//        employee.setAirport(airport);
//        employeeDAO.insert(employee);
//        employee1.setAirport(airport);
//        employeeDAO.insert(employee1);
        //3.2 redagavimas

        Airport airport1 = new Airport(1, "Palangos oro uostas", "Palangos g.", "Palanga");
        Employee employee2 = new Employee(1, "Braintas", "Diurantas", 150000);

//        airportDAO.update(airport1);
//        employee2.setAirport(airport1);
//        employeeDAO.update(employee2);

        //3.2 salinimas oro uosto

        employee1.setAirport(airport);
        airportDAO.delete(airport);




        HibernateUtil.getSessionFactory().close();
    }
}
