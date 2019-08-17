package com.cg.POSSprint5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.dto.PizzaDetails;
import com.cg.POSSprint5.dto.StoreDetails;
import com.cg.POSSprint5.exception.PizzaException;

@Repository
@Transactional
public class PizzaDaoImpl implements PizzaDao {
	@PersistenceContext
	private EntityManager manager;

	public PizzaDetails searchPizzaByName(PizzaDetails details) throws PizzaException{
	
		TypedQuery<PizzaDetails> query = manager.createQuery("select p from PizzaDetails p where p.itemName=:name",
				PizzaDetails.class);
		query.setParameter("name", details.getItemName());
	
		if(query.getSingleResult() == null) {
			throw new PizzaException("No such pizza available...!");
		}
	
	
		return query.getSingleResult();
	}

	public List<StoreDetails> searchStoreByPizzaName(PizzaDetails pizzaDetails) throws PizzaException{
		TypedQuery<StoreDetails> query = manager.createQuery(
				"select  s from StoreDetails s where s.storeId in (select p.storeId from PizzaDetails p where p.itemName=:name) ",
				StoreDetails.class);
		
		query.setParameter("name", pizzaDetails.getItemName());
//		try {
//		if(query.getResultList().isEmpty()) {
//			throw new PizzaException("exception");
//		}}catch (PizzaException e) {
//			throw new PizzaException("Sorry,Try again");
//		}
		if(query.getResultList().isEmpty()) {
			throw new PizzaException("StoreNotFound...!");
		}
		return query.getResultList();
		 
//		catch (PizzaException exception) {
//			throw new PizzaException("Sorry!Try again!");
//		}

	}
	
//	public List<CartDetails> searchMostOrderedPizzaById(PizzaDetails pizzaDetails) {
////		TypedQuery<CartDetails> query = manager.createQuery("select c from CartDetails c where c.itemId in (select p from CartDetails p group by p.id having count(*)>1)", CartDetails.class); 
//		TypedQuery<CartDetails> query = manager.createQuery("SELECT c.itemId, COUNT(*) from CartDetails c group by c.itemId having count(*)>1",CartDetails.class);
//		return query.getResultList();
//		
//	}
	
	public List<CartDetails> searchMostOrderedPizzaById() {
//		TypedQuery<CartDetails> query = manager.createQuery("select c from CartDetails c where c.itemId in (select p from CartDetails p group by p.id having count(*)>1)", CartDetails.class); 
		TypedQuery<CartDetails> query = manager.createQuery("SELECT c.itemId, COUNT(*) from CartDetails c GROUP BY c.itemId HAVING COUNT(*)>1",CartDetails.class);
		return query.getResultList();
		
	}

}
