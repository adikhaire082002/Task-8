package com.example.SpringTask8.repository;

import com.example.SpringTask8.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Dealer, Integer> {
    boolean existsByEmail(String email);
}
