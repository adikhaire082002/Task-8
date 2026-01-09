package com.example.SpringTask8.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private List<Product> products;


}
