package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
   /*private String name;
    private String email;
    private int age;*/

    private String name;
    private String email;
    private int age;
    private LocalDate createdAt;
    private Boolean isBlocked;

    public Student(String name, String email, int age, LocalDate createdAt, Boolean isBlocked) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.createdAt = createdAt;
        this.isBlocked = isBlocked;
    }
}
