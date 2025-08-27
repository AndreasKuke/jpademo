package app.dao;

import app.config.HibernateConfig;
import app.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class StudentDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    // Creates a student in db
    public Student createStudent(Student s){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        return s;
    }

    // Find all students
    public List<Student> findAll(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("from Student");
        List<Student> students = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return students;
    }

    // Update a student
    public Student updateStudent(Student s){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
        em.close();
        return s;
    }

    // Delete student
    public boolean deleteStudent(Student s){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    // Find student by course id
    public List<Student> findByCourseId(int courseId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            return em.createQuery("SELECT s from Student s where s.courseId.id = :courseId", Student.class)
                    .setParameter("courseId",courseId)
                    .getResultList();
        }finally {
            em.close();
        }

    }
}
