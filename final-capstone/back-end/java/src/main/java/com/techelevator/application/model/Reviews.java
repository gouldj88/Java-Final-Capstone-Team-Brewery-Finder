package com.techelevator.application.model;

public class Reviews {
	private int review_id;
	private int beer_id;
	private String review_text;
	private int star_rating;
	private String username;
	
	public Reviews() {
		
	}
	
	public Reviews(int beer_id, String review_text, int star_rating, String username) {
		this.beer_id = beer_id;
		this.review_text = review_text;
		this.star_rating = star_rating;
		this.username = username;
	}
	
	public Reviews(int review_id, int beer_id, String review_text, int star_rating, String username) {
		this.review_id = review_id;
		this.beer_id = beer_id;
		this.review_text = review_text;
		this.star_rating = star_rating;
		this.username = username;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getBeer_id() {
		return beer_id;
	}
	public void setBeer_id(int beer_id) {
		this.beer_id = beer_id;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
