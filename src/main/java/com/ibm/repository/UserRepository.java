package com.ibm.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.User;


public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
