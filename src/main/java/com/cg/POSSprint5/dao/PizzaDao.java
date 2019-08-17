package com.cg.POSSprint5.dao;

import java.util.List;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.dto.PizzaDetails;
import com.cg.POSSprint5.dto.StoreDetails;
import com.cg.POSSprint5.exception.PizzaException;

public interface PizzaDao {
	public PizzaDetails searchPizzaByName(PizzaDetails details) throws PizzaException;

	public List<StoreDetails> searchStoreByPizzaName(PizzaDetails pizzaDetails) throws PizzaException;

	public List<CartDetails> searchMostOrderedPizzaById();
}
