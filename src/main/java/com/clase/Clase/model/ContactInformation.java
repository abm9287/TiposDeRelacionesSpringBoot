package com.clase.Clase.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="contact_information")

public class ContactInformation 
{
    //Constructor
    public ContactInformation(String email, String phone, String address, String city, String state)
    {
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state; 
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_information_sequence")
    @SequenceGenerator(name = "contact_information_sequence", allocationSize = 1)
    private Long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state; 


    //Relación one to one
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "student_id")
    private Student student;


    //Sobre-escritura 
    @Override
    public String toString() 
    {
        return "Contact Information: {" + 
        "id: " + id 
        + "Email:" + email 
        + "Phone: " + phone
        + "Address: " + address
        + "City: " + city
        + "State: " + state
        +"}";
    }

    
}
