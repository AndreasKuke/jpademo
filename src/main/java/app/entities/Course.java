package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Course {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String teacher;

    String semester;

    String classroom;

}

