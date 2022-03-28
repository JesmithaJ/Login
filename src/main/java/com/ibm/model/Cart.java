package com.ibm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 2, max = 100, message = "Description must be b/w 5-100")
	private String cartProduct;
	
	private int quantity;
	
	private Double cost;
	
	
}

