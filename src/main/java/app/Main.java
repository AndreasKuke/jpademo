package app;


import app.dao.CourseDAO;
import app.dao.PersonDAO;
import app.dao.StudentDAO;
import app.entities.Course;
import app.entities.Person;
import app.entities.Student;
import app.entities.StudentStatus;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // DAO
        PersonDAO personDAO = new PersonDAO();
        CourseDAO courseDAO = new CourseDAO();
        StudentDAO studentDAO = new StudentDAO();

        Person person = Person.builder()
                .name("Emil")
                .age(80)
                .build();

        // Create a person
        personDAO.createPerson(person);



        Course course1  = Course.builder()
                .name("JAVA 101")
                .teacher("Jon")
                .semester("Spring")
                .classroom("C 3.7")
                .build();

        Course course2 = Course.builder()
                .name("Javascript")
                .teacher("not sure")
                .semester("Winter")
                .classroom("C 3.9")
                .build();

        // Creation of courses
        courseDAO.createCourse(course1);
        courseDAO.createCourse(course2);


        Student student1 = Student.builder()
                .name("Kuke")
                .email("kuke@mail.dk")
                .phone("+45 12 34 56 78")
                .address("Hjem")
                .status(StudentStatus.ACTIVE)
                .dateOfBirth(LocalDate.of(2001,4,9))
                .dateOfEnrollment(LocalDate.of(2024,7,23))
                .courseId(course1)
                .build();

        Student student2 = Student.builder()
                .name("Emil")
                .email("emil@mail.dk")
                .phone("+45 22 33 55 77")
                .address("Grotte")
                .status(StudentStatus.ACTIVE)
                .dateOfBirth(LocalDate.of(1876,3,2))
                .dateOfEnrollment(LocalDate.of(2024,7,23))
                .courseId(course1)
                .build();

        // Creation of students
        studentDAO.createStudent(student1);
        studentDAO.createStudent(student2);

        System.out.println("All students:");
        studentDAO.findAll().forEach(System.out::println);

        System.out.println("\nAll courses:");
        courseDAO.findAll().forEach(System.out::println);

        System.out.println("\nAll students from course 1:");
        studentDAO.findByCourseId(course1.getId()).forEach(System.out::println);

        }




    }
