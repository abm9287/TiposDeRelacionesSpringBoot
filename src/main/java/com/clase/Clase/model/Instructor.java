package com.clase.Clase.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor 
{

    //Cosntructor
    public Instructor(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName; 
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_sequence")
    @SequenceGenerator(name = "instructor_sequence", allocationSize = 1)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName; 

    //Relación One to Many
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

    //Sobreescritura del método toString
    @Override
    public String toString() 
    {
        return "Instructor{" + "id: " + id + "Firstname: " + firstName + "Lastname: " + lastName + "}";
    }
}
