package com.example.SpringTask8.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int age;

    @OneToOne(mappedBy = "profile")
    private Dealer dealer;
}
