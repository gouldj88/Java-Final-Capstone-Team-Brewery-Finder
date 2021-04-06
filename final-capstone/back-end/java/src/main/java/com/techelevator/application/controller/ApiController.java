/********************************************************************************************************************** 
* This will should contain Application API Controllers and related objects
**********************************************************************************************************************/

package com.techelevator.application.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.BreweryDAO;
import com.techelevator.application.model.Brewery;

/**********************************************************************************************************************
* Put your Application API Controllers here
**********************************************************************************************************************/
@RestController
@CrossOrigin

public class ApiController {

	private BreweryDAO breweryDAO;

	public ApiController(BreweryDAO breweryDAO) {
		this.breweryDAO = breweryDAO;
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

