package com.clase.Clase.model;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 


@Setter
@Getter
@NoArgsConstructor
@Entity 
@Table(name="student")
public class Student 
{
    //Constructor 
    public Student(String firstName, String lastName, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name="student_generator", allocationSize = 1)
    private Long id;
    
    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="birth_date", nullable = false)
    private LocalDate birthDate;

    //Relación One to One
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContactInformation contactInformation;



    //Sobreescribe el método toString 
    @Override
    public String toString() {
        return "Student{" + "id:" + id + "Firstname: " + firstName + "Lastname: " + lastName + "Birthdate: " + birthDate + "}";
    }

}
