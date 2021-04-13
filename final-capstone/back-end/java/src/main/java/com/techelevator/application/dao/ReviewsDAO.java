package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Reviews;

public interface ReviewsDAO {

	
	List<Reviews> getReviewsByBeerId(int id);
	
	void addReview(Reviews newReview);
	
	void deleteReview(int reviewId);
	
}
