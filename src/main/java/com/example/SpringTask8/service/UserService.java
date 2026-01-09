package com.example.SpringTask8.service;

import com.example.SpringTask8.entity.Dealer;

import java.util.List;

public interface UserService {

    public  String addUser(Dealer dealer);

    public  String updateUser(Dealer dealer, int id);

    String deleteUser(Integer id);

    public Dealer getUserById(Integer id);
    public List<Dealer> getAllUser();
}
