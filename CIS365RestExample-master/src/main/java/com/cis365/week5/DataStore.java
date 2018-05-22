package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import com.cis365.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
            String dbName = System.getenv("RDS_DB_NAME");
            String userName = System.getenv("RDS_USERNAME");
            String password = System.getenv("RDS_PASSWORD");
            String hostname = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;
            

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    
    
    
    public static List<Planet> listPlanets(){
        Session session = getSessionFactory().openSession();
       try {
            return session.createQuery("FROM Planet").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
         
    }

    public static List<Starship> listStarships(){
    Session session = getSessionFactory().openSession();
    try{
            return session.createQuery("FROM Starship").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    
    }
    
    public static List<PlanetVisit> listVisits(){
        Session session = getSessionFactory().openSession();
         try{
            return session.createQuery("FROM Planetvisit").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
      
    }
    public static Planet findPlanetById(String planetName) {
        Session session = getSessionFactory().openSession();

        try {
            return (Planet) session.get(Planet.class, planetName);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
     public static Planet findStarshipById(String starshipName) {
        Session session = getSessionFactory().openSession();
        try {
            return (Starship) session.get(Starship.class, starshipName);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
        public static Planet findVisitById(String visitName) {
        Session session = getSessionFactory().openSession();

        try {
            return (Starship) session.get(Starship.class, visitName);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
     


    public static Planet updatePlanet(String planetName, Planet planetToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetName);
            if (existing != null && planetName == planetToUpdate.getName())
                existing = planetToUpdate;
            tx.commit();
            return planetToUpdate;
        }  catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    
    
    public static Starship updateStarship(String starshipName, Starship starshipToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Starship existing = findStarshipById(starshipName);
            if (existing != null && starshipName == starshipToUpdate.getName())
                existing = starshipToUpdate;
            tx.commit();
            return starshipToUpdate;
        }  catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    public static PlanetVisit updateVisit(String planetName, PlanetVisit visitToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetName);
            if (existing != null && planetName == visitToUpdate.getPlanet())
                existing = visitToUpdate;
            tx.commit();
            return visitToUpdate;
        }  catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}