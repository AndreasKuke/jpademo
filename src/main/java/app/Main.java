package app;


import app.dao.PersonDAO;
import app.entities.Person;

public class Main {
    public static void main(String[] args) {

        PersonDAO dao = new PersonDAO();

        Person person = Person.builder()
                .name("Emil")
                .age(80)
                .build();

        // Create a person
        dao.createPerson(person);
        }
    }
