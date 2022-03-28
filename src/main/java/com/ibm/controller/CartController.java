package com.ibm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Cart;
import com.ibm.service.CartService;

@CrossOrigin
@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("cart")
	public ResponseEntity<List<Cart>> getCarts(){
		return ResponseEntity.ok(cartService.getCart());
	}
	
	@GetMapping("cart/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable int id){
		return ResponseEntity.ok(cartService.getCart(id));
	}
	
/*	@GetMapping("cart/user/{user}")
	public ResponseEntity<List<Cart>> getCartsByUser(@PathVariable String user){
		return ResponseEntity.ok(cartService.getCartsByUser(user));
	}*/
	
	@PostMapping("cart")
	public ResponseEntity<Cart>  addCart(@Valid @RequestBody Cart cart){
		Cart result = cartService.addCart(cart);
		URI link = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(link).body(result);
	}
	
	@PutMapping("cart/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int id, @Valid @RequestBody Cart cart){
		return ResponseEntity.ok(cartService.updateCart(id, cart));
	}
	
	@DeleteMapping("cart/{id}")
	public  ResponseEntity<?> deleteCart(@PathVariable int id)
	{
		if(cartService.deleteCart(id))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}

}