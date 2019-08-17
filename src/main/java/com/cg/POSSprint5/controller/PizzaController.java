package com.cg.POSSprint5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.POSSprint5.dto.CartDetails;
import com.cg.POSSprint5.dto.PizzaDetails;
import com.cg.POSSprint5.dto.StoreDetails;
import com.cg.POSSprint5.exception.PizzaException;
import com.cg.POSSprint5.service.PizzaService;

@RestController
//@RequestMapping(value = "/pizza")
@CrossOrigin(origins = "http://localhost:2501")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/JSON", consumes = "application/JSON")

	public PizzaDetails searchPizzaByName(@RequestBody PizzaDetails pizzaDetails) throws PizzaException {

		LOGGER.info("Searching Pizza.....");
		LOGGER.info("Search complete");
		return pizzaService.searchPizzaByName(pizzaDetails);

	}

	@RequestMapping(value = "/searchstore", method = RequestMethod.POST, produces = "application/JSON", consumes = "application/JSON")

	public List<StoreDetails> searchStoreByPizzaName(@RequestBody PizzaDetails pizzaDetails) throws PizzaException {

        LOGGER.info("Searching Stores");
        LOGGER.info("Search complete");
		return pizzaService.searchStoreByPizzaName(pizzaDetails);

		}
	
//	@RequestMapping(value = "/search/mostOrderedPizza", method = RequestMethod.POST, produces = "appliocation/JSON")
//	public List<CartDetails> searchMostOrderedPizzaById(PizzaDetails pizzaDetails) throws PizzaException{
//		
//        LOGGER.info("Searching for favourites");
//		return pizzaService.searchMostOrderedPizzaById(pizzaDetails);
//		
//	}
	@RequestMapping(value = "/PopularPizzas", method = RequestMethod.POST, produces = "appliocation/JSON")
	public List<CartDetails> searchMostOrderedPizzaById() throws PizzaException{
		
        LOGGER.info("Searching for favourites");
		return pizzaService.searchMostOrderedPizzaById();
		
	}
	
}
