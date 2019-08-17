package com.cg.POSSprint5.dao;

import com.cg.POSSprint5.dto.CartDetails;

public interface CartDao {

	CartDetails addToCart(CartDetails cartDetails) ; 
	
	CartDetails viewCart(CartDetails cartDetails) ;

	int removeItem(CartDetails cartDetails);

	CartDetails deleteCart(CartDetails cartDetails);
	
//	CartDetails addItem(CartDetails cartDetails);

}