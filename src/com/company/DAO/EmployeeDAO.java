package com.company.DAO;

import com.company.entity.Airport;
import com.company.entity.Employee;
import com.company.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {


    public EmployeeDAO() {

    }

    public void insert(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(employee);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai iterpti nauja irasa.");
    }

    public Employee searchById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal ID.");

        return employee;
    }

    public void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(employee);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atnaujinti irasa.");
    }

    public void delete(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(employee);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai pasalinti irasa.");
    }

    public List<Employee> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Employee> employees = new ArrayList<>();
        Query q = session.createQuery("SELECT count(e) from Employee e where e.name like'" + name + "'");
        List l = q.list();
        //Long result[] = (Long[]) l.get(0);
        //Integer res = (Integer) result[0];
        System.out.println("Pagal count uzklausa Jonu skaicius: " + l.get(0));
        employees = session.createQuery("from Employee e where e.name like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return employees;
    }

    public List<Employee> printAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Employee> employees = new ArrayList<>();
        employees = session.createQuery("from Employee").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atspausdinti visus irasus.");

        return employees;
    }

}
