package com.clase.Clase.model;




import jakarta.persistence.*;
import lombok.NoArgsConstructor;






@Entity

@NoArgsConstructor
@Table(name="course")
public class Course {
    // Constructor
    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Relación Many to One
    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;

    
    

    // Sobreescribe el método toString
    @Override
    public String toString() {
        return "Course {" + "id:" + id + "Name: " + name + "}";
    }
}
