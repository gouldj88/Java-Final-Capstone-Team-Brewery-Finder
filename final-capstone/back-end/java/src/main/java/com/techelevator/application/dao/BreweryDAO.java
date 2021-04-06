package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Brewery;

public interface BreweryDAO {
	
	List<Brewery> getBreweriesByZipCode(String zipCode);
	
	List<Brewery> getBreweriesByName(String name);
		
	List<Brewery> getBreweriesByCity(String city);
	
	List<Brewery> getBreweriesByState(String state);
	
	void createNewBrewery(String name, String street, String city, String state, 
					      String postal_code, String website_url, String phone);
}

