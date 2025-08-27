package app.dao;

import app.config.HibernateConfig;
import app.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class CourseDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();


    // Creates a course
    public Course createCourse(Course c){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    // Find all courses
    public List<Course> findAll(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("from Course");
        return q.getResultList();
    }

    // Update a course
    public Course updateCourse(Course c){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        return c;
    }

    // Delete a course by ID
    public boolean deleteById(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course c = em.find(Course.class, id);
        em.remove(c);
        em.getTransaction().commit();
        return true;
    }
}
