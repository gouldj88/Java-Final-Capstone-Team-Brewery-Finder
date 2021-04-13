package com.techelevator.application.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.model.Reviews;

@Component
public class ReviewsSQLDAO implements ReviewsDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	public List<Reviews> getReviewbyBeerId(String id) {
		List<Reviews> reviewList = new ArrayList();
		String sqlQuery = "select * from reviews where beer_id=?";
		SqlRowSet theRows = jdbcTemplate.queryForRowSet(sqlQuery, id);
		while(theRows.next()) {
			Reviews aReview = mapRowToReview(theRows);
			reviewList.add(aReview);
		}
		return reviewList;
		
	}
	
	public void addReview(Reviews aReview) {
		String newReview = "INSERT INTO reviews (beer_id, review_text, star_rating, username) " + 
						   "VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(newReview, aReview.getBeer_id(), aReview.getReview_text(), aReview.getStar_rating(), aReview.getUsername());
		
	}
	
	public void deleteReview(int reviewId) {
		String reviewDelete = "delete from Reviews where review_id = ?";
		jdbcTemplate.update(reviewDelete, reviewId);
	}
	
	public Reviews mapRowToReview(SqlRowSet rs) {
		Reviews reviews = new Reviews();
		reviews.setReview_id(rs.getInt("review_id"));
		reviews.setBeer_id(rs.getInt("beer_id"));
		reviews.setReview_text(rs.getString("review_text"));
		reviews.setStar_rating(rs.getInt("star_rating"));
		reviews.setUsername(rs.getString("username"));
		return reviews;
	}
	
}
