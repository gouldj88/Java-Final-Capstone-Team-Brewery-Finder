package com.techelevator.application.model;


public class Beer {
	private String beer_id;
	private String obdb_id;
	private String name;
	private String brewery;
	private String description;
	private String image;
	private String abv;
	private String type;
	private String active;
	
	public Beer() {
	}
	
	public Beer(String obdb_id, String name, String brewery, String description, String image, String abv, String type, String active) {
		this.obdb_id = obdb_id;
		this.name = name;
		this.brewery = brewery;
		this.description = description;
		this.image = image;
		this.abv = abv;
		this.type = type;
		this.active = active;
	}
	
	public Beer(String beer_id, String obdb_id, String name, String brewery, String description, String image, String abv, String type, String active) {
		this.beer_id = beer_id;
		this.obdb_id = obdb_id;
		this.name = name;
		this.brewery = brewery;
		this.description = description;
		this.image = image;
		this.abv = abv;
		this.type = type;
		this.active = active;
	}
	
	public String getBeer_id() {
		return beer_id;
	}
	
	public void setBeer_id(String beer_id) {
		this.beer_id = beer_id;
	}

	public String getObdb_id() {
		return obdb_id;
	}

	public void setObdb_id(String obdb_id) {
		this.obdb_id = obdb_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAbv() {
		return abv;
	}

	public void setAbv(String abv) {
		this.abv = abv;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}