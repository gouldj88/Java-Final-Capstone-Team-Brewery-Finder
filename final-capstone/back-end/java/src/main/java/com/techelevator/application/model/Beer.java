package com.techelevator.application.model;


public class Beer {
	private String beer_id;
	private String obdb_id;
	private String name;
	private String description;
	private String image;
	private String abv;
	private String type;
	
	public Beer() {
	}
	
	public Beer(String obdb_id, String name, String description, String image, String abv, String type) {
		this.obdb_id = obdb_id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.abv = abv;
		this.type = type;
	}
	
	public Beer(String beer_id, String obdb_id, String name, String description, String image, String abv, String type) {
		this.beer_id = beer_id;
		this.obdb_id = obdb_id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.abv = abv;
		this.type = type;
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
}