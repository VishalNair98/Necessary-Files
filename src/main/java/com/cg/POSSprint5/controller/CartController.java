package com.cg.POSSprint5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.exception.PizzaException;
import com.cg.POSSprint5.service.CartService;


@RestController
@CrossOrigin(origins = "http://localhost:2501")
//@RequestMapping("/Services")
public class CartController {
	@Autowired
	private CartService cartService;

	/**
	 * @param cartService the cartService to set
	 */
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@RequestMapping(value = "/addItems", method = RequestMethod.POST, produces = "application/JSON", consumes = "application/JSON")

	public CartDetails addItemToCart(@RequestBody CartDetails cartDetails) throws PizzaException {
//		CartDetails cartDetails = new CartDetails();
		try {
			cartDetails = cartService.addToCart(cartDetails);
			throw new PizzaException("Something Went Wrong!!Please Try Again Later");
		} catch (PizzaException e) {
//			System.out.println(e);
		}
		return cartDetails;
	}
	
//	@RequestMapping(value = "/addItem", method = RequestMethod.POST, produces = "application/JSON", consumes = "application/JSON")
//	public CartDetails addItem(@RequestBody CartDetails cartDetails){
//	    cartDetails = cartService.addItem(cartDetails); 
//		return cartDetails;
//		
//	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.POST, produces = "application/JSON", consumes = "application/JSON")

	public CartDetails viewCart(@RequestBody CartDetails cartDetails) throws PizzaException {
		int flag = 0;
		try {
			cartDetails = cartService.viewCart(cartDetails);

		} catch (PizzaException e) {
			flag = 1;
		}
		if (flag == 0) {
			return cartDetails;
		} else
			return null;
	}

	@RequestMapping(value = "/removeCart", method = RequestMethod.DELETE, produces = "application/JSON", consumes = "application/JSON")

	public String removeCart(@RequestBody CartDetails cartDetails) throws PizzaException {
		int counter = 0;
		try {
			counter = cartService.removeItem(cartDetails);
			System.out.println(cartDetails.getCartId());
		} catch (PizzaException e) {

		}
		if (counter == 0) {
			return "success";
		} else
			return "not in database";

	}
	
	
}
