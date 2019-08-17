package com.cg.POSSprint5.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.dto.PizzaDetails;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * @param manager the manager to set
	 */
	public CartDetails addToCart(CartDetails cartDetails) {
		PizzaDetails pizzaDetails = new PizzaDetails();
		pizzaDetails = manager.find(PizzaDetails.class, pizzaDetails.getItemId());
		if (pizzaDetails != null) {
			cartDetails.setItemId(pizzaDetails.getItemId());
			cartDetails.setRestCharge(pizzaDetails.getPrice());
			cartDetails.setDelvCharge(50);
			cartDetails.setQuantity(pizzaDetails.getQuantity());
			cartDetails
					.setTotal((cartDetails.getRestCharge() + cartDetails.getDelvCharge()) * cartDetails.getQuantity());
			manager.persist(cartDetails);
		}
		return cartDetails;
	}
	
//	public CartDetails addItem(CartDetails cartDetails) {
//		PizzaDetails pizzaDetails = new PizzaDetails();
//		pizzaDetails= manager.find(PizzaDetails.class, pizzaDetails.getItemId());
//		if(pizzaDetails != null) {
//			cartDetails.setCartId(pizzaDetails.getItemId());
//			cartDetails.setRestCharge(pizzaDetails.getPrice());
//			cartDetails.setDelvCharge(50);
//			cartDetails.setQuantity(cartDetails.getQuantity());
//			cartDetails
//			.setTotal((cartDetails.getRestCharge() + cartDetails.getDelvCharge()) * cartDetails.getQuantity());
//		}
//		return cartDetails;
//		
//	}

	public CartDetails viewCart(CartDetails cartDetails) {

		return manager.find(CartDetails.class, cartDetails.getCartId());

	}

	public int removeItem(CartDetails cartDetails) {
		CartDetails cart = manager.find(CartDetails.class, cartDetails.getCartId());
		if (cart == null) {
			return 1;
		} else
			manager.remove(cart);
		return 0;
	}

	public CartDetails deleteCart(CartDetails cartDetails) {
		CartDetails emptyCart = new CartDetails();
		Query deleteCart = manager
				.createQuery("delete cartInfo from CartDetails cartInfo where cartInfo.CartDetails.id =: cartId");
		deleteCart.setParameter("cartId", cartDetails.getCartId());
		int execution = deleteCart.executeUpdate();
		if (execution == 1) {
			emptyCart = cartDetails;
		}
		return emptyCart;
	}

}
