package com.insignia.assessment.model;
import jakarta.persistence.*;
@Entity
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}