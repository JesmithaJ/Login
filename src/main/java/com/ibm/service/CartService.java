package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exception.TodoNotFoundException;
import com.ibm.model.Cart;
import com.ibm.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartrepo;

	public List<Cart> getCart() {
		return cartrepo.findAll();
	}

	public Cart getCart(int id) {
		return cartrepo.findById(id).orElseThrow(TodoNotFoundException::new);
	}

/*	public List<Todo> getTodosByUser(String user) {
		return todorepo.findAllByUser(user);
	}*/

	public Cart addCart(Cart cart) {
		return cartrepo.save(cart);
	}

	public Cart updateCart(int id, Cart cart) {
		if (getCart(id) != null) {
			return cartrepo.saveAndFlush(cart);
		}
		return null;
	}

	public boolean deleteCart(int id) {
		if (getCart(id) != null) {
			cartrepo.deleteById(id);
			return true;
		}
		return false;
	}
}
