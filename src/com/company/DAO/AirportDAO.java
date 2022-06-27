package com.company.DAO;

import com.company.entity.Airport;
import com.company.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AirportDAO {


    public AirportDAO() {

    }

    public void insert(Airport airport) {
        // Norint atlikti uzklausa i DB reikia is sesiju gamyklos paprasyti sesijos.
        // Sesiju objektas yra lengvasvoris (lightweight).
        // Sesiju galima tureti neribota kieki per aplikacija.
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(airport);

        session.getTransaction().commit();
        System.out.println("Sekmingai issaugojam nauja objekta.");
    }

    public void update(Airport airport) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(airport);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai atnaujinti (pagal ID).");
    }

    public void delete(Airport airport) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(airport);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai pasalinti.");
    }

    public Airport searchByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Airport airport = session.get(Airport.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko atlikti paieska sekmingai pagal ID.");

        return airport;
    }

    public List<Airport> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Airport> airports = new ArrayList<>();
        // Panaudosime hibernate query language (HQL). Naudojama su metodu create query.
        airports = session.createQuery("from Airport a where a.name like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return airports;
    }


}
