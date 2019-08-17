package com.cg.POSSprint5.service;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.exception.PizzaException;

public interface CartService {

	CartDetails addToCart(CartDetails cartDetails) throws PizzaException;

	CartDetails viewCart(CartDetails cartDetails) throws PizzaException;

	int removeItem(CartDetails cartDetails) throws PizzaException;

	CartDetails deleteCart(CartDetails cartDetails) throws PizzaException;
	
//	CartDetails addItem(CartDetails cartDetails);
	


}