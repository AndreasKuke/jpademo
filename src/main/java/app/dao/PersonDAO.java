package app.dao;

import app.config.HibernateConfig;
import app.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PersonDAO {

EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public Person createPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        return person;
    }
}
