/********************************************************************************************************************** 
* This will should contain Application API Controllers and related objects
**********************************************************************************************************************/

package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.BeerDAO;
import com.techelevator.application.dao.BreweryDAO;
import com.techelevator.application.dao.BreweryDetailsDAO;
import com.techelevator.application.dao.ReviewsDAO;
import com.techelevator.application.model.Beer;
import com.techelevator.application.model.Brewery;
import com.techelevator.application.model.BreweryDetails;
import com.techelevator.application.model.Reviews;

/**********************************************************************************************************************
* Put your Application API Controllers here
**********************************************************************************************************************/
@RestController
@CrossOrigin

public class ApiController {

	private BreweryDAO breweryDAO;
	private BeerDAO beerDAO;
	private BreweryDetailsDAO breweryDetailsDAO;
	private ReviewsDAO reviewsDAO;
	

	public ApiController(BreweryDAO breweryDAO, BeerDAO beerDAO, BreweryDetailsDAO breweryDetailsDAO, ReviewsDAO reviewsDAO) {
		this.breweryDAO = breweryDAO;
		this.beerDAO = beerDAO;
		this.breweryDetailsDAO = breweryDetailsDAO;
		this.reviewsDAO = reviewsDAO;
	}
	
	@RequestMapping(path = "/breweries/{obdbId}", method = RequestMethod.GET)
	public List<Brewery> getSingleBreweryInfo(@PathVariable String obdbId) {
	    return breweryDAO.getSingleBreweryInfo(obdbId);
	}
	
	@RequestMapping(path = "/breweries/location/zip/{zipCode}", method = RequestMethod.GET)
	public List<Brewery> getBreweriesByZipCode(@PathVariable String zipCode) {
	    return breweryDAO.getBreweriesByZipCode(zipCode);
	}
	
	@RequestMapping(path = "/breweries/name/{name}", method = RequestMethod.GET)
	public List<Brewery> getBreweriesByName(@PathVariable String name) {
	    return breweryDAO.getBreweriesByName(name);
	}
	
	@RequestMapping(path = "/breweries/location/city/{city}", method = RequestMethod.GET)
	public List<Brewery> getBreweriesByCity(@PathVariable String city) {
	    return breweryDAO.getBreweriesByCity(city);
	}
	
	@RequestMapping(path = "/breweries/location/state/{state}", method = RequestMethod.GET)
	public List<Brewery> getBreweriesByState(@PathVariable String state) {
	    return breweryDAO.getBreweriesByState(state);
	}
	
	@RequestMapping(path = "/addBrewery", method = RequestMethod.POST)
	public void createNewBrewery(@RequestBody Brewery formBrewery) {
	    breweryDAO.createNewBrewery(formBrewery);
	}
	
	// Beer Bits
	
	@RequestMapping(path = "/breweries/{obdbId}/beerlist", method = RequestMethod.GET)
	public List<Beer> getBeerListByBrewery(@PathVariable String obdbId) {
	    return beerDAO.getBeerListByBrewery(obdbId);
	}
	
	@RequestMapping(path = "/beers/{beerId}", method = RequestMethod.GET)
	public List<Beer> getSingleBeerInfo(@PathVariable String beerId) {
	    return beerDAO.getSingleBeerInfo(beerId);
	}

	@RequestMapping(path = "/beers/maintenance/addBeer", method = RequestMethod.POST)
	public void addABeer(@RequestBody Beer formData) {
	    beerDAO.addABeer(formData);
	}
	
	@RequestMapping(path = "/beers/maintenance/deleteBeer/{beerId}", method = RequestMethod.POST)
	public void deleteABeer(@PathVariable String beerId) {
	    beerDAO.deleteABeer(beerId);
	}
	
	// Brewery Details bit
	
	@RequestMapping(path = "/breweries/{obdbId}/details", method = RequestMethod.GET)
	public List<BreweryDetails> getBreweryDetailsById(@PathVariable String obdbId) {
	    return breweryDetailsDAO.getBreweryDetailsById(obdbId);
	}
	
	@RequestMapping(path = "/breweries/addDetails", method = RequestMethod.POST)
	public void addBreweryDetails(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.addBreweryDetails(formData);
	}
	
	@RequestMapping(path = "/breweries/addDetails/history", method = RequestMethod.POST)
	public void updateBreweryHistory(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryHistory(formData);
	}
	
	@RequestMapping(path = "/breweries/addDetails/image", method = RequestMethod.POST)
	public void updateBreweryImage(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryImage(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/hourOpen", method = RequestMethod.POST)
	public void updateBreweryHourOpen(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryHourOpen(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/hourClosed", method = RequestMethod.POST)
	public void updateBreweryHourClosed(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryHourClosed(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openSun", method = RequestMethod.POST)
	public void updateBreweryOpenSun(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryOpenSun(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openMon", method = RequestMethod.POST)
	public void updateBreweryOpenMon(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryOpenMon(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openTue", method = RequestMethod.POST)
	public void updateBreweryOpenTue(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryOpenTue(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openWed", method = RequestMethod.POST)
	public void updateBreweryOpenWed(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryOpenWed(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openThu", method = RequestMethod.POST)
	public void updateBreweryOpenThu(@RequestBody BreweryDetails formData) {
	    breweryDetailsDAO.updateBreweryOpenThu(formData);
	}

	@RequestMapping(path = "/breweries/addDetails/openFri", method = RequestMethod.POST)
	public void updateBreweryOpenFri(BreweryDetails formData){
	    breweryDetailsDAO.updateBreweryOpenFri(formData);
	}
	
	@RequestMapping(path = "/breweries/addDetails/openSat", method = RequestMethod.POST)
	public void updateBreweryOpenSat(@RequestBody BreweryDetails formData){
	    breweryDetailsDAO.updateBreweryOpenSat(formData);
	}
	
	@RequestMapping(path = "/reviews/{beerId}", method = RequestMethod.GET)
	public List<Reviews> getReviewsByBeerId(@PathVariable("beerId") int beerId) {
	    return reviewsDAO.getReviewsByBeerId(beerId);
	}
	
	@RequestMapping(path = "/reviews/maintenance/addReview", method = RequestMethod.POST)
	public void addReview(@RequestBody Reviews formData) {
		reviewsDAO.addReview(formData);
	}
	
	
/********************************************************************************************************************* 
* Use this method if you'd like to log calls to your controllers - these message can aid in your troubleshooting
* 
* To use it: logRequest("a message you want to appear after the timestamp in the server log")
* 
* There are examples in the AuthenicationController.java program in the com.techelevator.security.controller package
**********************************************************************************************************************/	
    static void logRequest(String message) {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	 
    	System.out.println(timestamp + " - " + message);
    }
}

