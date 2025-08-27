package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    Integer id;

    String name;

    String phone;

    String email;

    String address;

    StudentStatus status;

    LocalDate dateOfBirth;

    LocalDate dateOfEnrollment;

    Integer courseId;
}
