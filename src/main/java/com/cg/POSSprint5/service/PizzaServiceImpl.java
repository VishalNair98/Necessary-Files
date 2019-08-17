package com.cg.POSSprint5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.POSSprint5.dao.PizzaDao;
import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.dto.PizzaDetails;
import com.cg.POSSprint5.dto.StoreDetails;
import com.cg.POSSprint5.exception.PizzaException;

@Service
public class PizzaServiceImpl implements PizzaService {
	@Autowired
	private PizzaDao pizzaDao;

	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	public PizzaDetails searchPizzaByName(PizzaDetails details) throws PizzaException {

		return pizzaDao.searchPizzaByName(details);
	}

	public List<StoreDetails> searchStoreByPizzaName(PizzaDetails pizzaDetails) throws PizzaException {
		
		return pizzaDao.searchStoreByPizzaName(pizzaDetails);
	}
	
	public List<CartDetails> searchMostOrderedPizzaById() {
		
		return pizzaDao. searchMostOrderedPizzaById();
		
	
	}

}
