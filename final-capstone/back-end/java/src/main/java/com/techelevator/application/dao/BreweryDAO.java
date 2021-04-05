package com.techelevator.application.dao;

import com.techelevator.application.model.Brewery;

public interface BreweryDAO {
	Brewery getBreweryByZipCode(String zipCode);
	
	Brewery getBreweryByName(String name);
	
	Brewery getBreweryByCityState(String city, String state);
	
	Brewery getBreweryByCity(String city);
	
	Brewery getBreweryByState(String state);

		
}

