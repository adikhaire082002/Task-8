package com.example.SpringTask8.repository;

import com.example.SpringTask8.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {
}
