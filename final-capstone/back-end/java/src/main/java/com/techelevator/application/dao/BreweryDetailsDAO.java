package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.BreweryDetails;

public interface BreweryDetailsDAO {
	
	List<BreweryDetails> getBreweryDetailsById(String id);
	
	void addBreweryDetails(BreweryDetails formData);
	
	void updateBreweryHistory(BreweryDetails formData);
	
	void updateBreweryImage(BreweryDetails formData);

	void updateBreweryHourOpen(BreweryDetails formData);

	void updateBreweryHourClosed(BreweryDetails formData);

	void updateBreweryOpenSun(BreweryDetails formData);

	void updateBreweryOpenMon(BreweryDetails formData);

	void updateBreweryOpenTue(BreweryDetails formData);

	void updateBreweryOpenWed(BreweryDetails formData);

	void updateBreweryOpenThu(BreweryDetails formData);

	void updateBreweryOpenFri(BreweryDetails formData);

	void updateBreweryOpenSat(BreweryDetails formData);
}

