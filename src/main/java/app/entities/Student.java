package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String phone;

    String email;

    String address;

    StudentStatus status;

    LocalDate dateOfBirth;

    LocalDate dateOfEnrollment;

    @ManyToOne
            @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_student_course")
            )
    Course courseId;
}
