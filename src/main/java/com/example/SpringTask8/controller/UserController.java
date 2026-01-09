package com.example.SpringTask8.controller;

import com.example.SpringTask8.entity.Dealer;
import com.example.SpringTask8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Dealer dealer){
        String s = userService.addUser(dealer);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Dealer dealer, @RequestParam Integer id){
        String s = userService.updateUser(dealer,id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @GetMapping("/getDealer")
    public ResponseEntity<?> getProduct(@RequestParam Integer id){
        Dealer dealerById = userService.getUserById(id);
        return new ResponseEntity<>(dealerById,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct(){
        List<Dealer> allDealer = userService.getAllUser();
        return new ResponseEntity<>(allDealer,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id){
        String s = userService.deleteUser(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
