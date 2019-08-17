package com.cg.POSSprint5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.POSSprint5.dao.CartDao;
import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.exception.PizzaException;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;

	public void setCartConnect(CartDao cartConnect) {
		this.cartDao = cartConnect;
	}

	public CartDetails viewCart(CartDetails cartDetails) throws PizzaException {
		return cartDao.viewCart(cartDetails);

	}

	public int removeItem(CartDetails cartDetails) throws PizzaException {
		return cartDao.removeItem(cartDetails);

	}

	public CartDetails deleteCart(CartDetails cartDetails) throws PizzaException {
		return cartDao.deleteCart(cartDetails);

	}

	public CartDetails addToCart(CartDetails cartDetails) throws PizzaException {
		
		return  cartDao.addToCart(cartDetails);
	}
	
//	public CartDetails addItem(CartDetails cartDetails) {
//		return cartDao.addItem(cartDetails);
//		
//	}


}
