package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Beer;

public interface BeerDAO {
	
	List<Beer> getBeerListByBrewery(String obdbId);
	
	List<Beer> getSingleBeerInfo(String beerId);
		
	void addABeer(Beer formData);
	
	void updateBeerStatus (Beer formData);

	void deleteABeer(String beerId);
}

