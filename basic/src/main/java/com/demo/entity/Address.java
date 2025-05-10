package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "`address`")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;
}

/***
 * address:
 * id (PK)
 * street
 * city
 * zip_code
 */
