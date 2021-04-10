package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Brewery;

public interface BreweryDAO {
	
	List<Brewery> getBreweriesByZipCode(String zipCode);
	
	List<Brewery> getBreweriesByName(String name);
		
	List<Brewery> getBreweriesByCity(String city);
	
	List<Brewery> getBreweriesByState(String state);
	
	List<Brewery> getSingleBreweryInfo(String obdbId);
	
	void createNewBrewery(Brewery formData);
}

