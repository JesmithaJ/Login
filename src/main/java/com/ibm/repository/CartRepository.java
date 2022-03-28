package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.Cart;
import com.ibm.model.Todo;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
//	List<Todo> findAllByUser(String username);
}
