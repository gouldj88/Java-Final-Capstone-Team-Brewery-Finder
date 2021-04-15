package com.techelevator.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.model.BreweryDetails;
import com.techelevator.application.model.Reviews;

@Component
public class ReviewsSQLDAO implements ReviewsDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ReviewsSQLDAO(DataSource aDataSource) {
        this.jdbcTemplate = new JdbcTemplate(aDataSource);
    } 
	
	
	public List<Reviews> getAverageStarsById(int id) {
		List<Reviews> returnedDetails = new ArrayList();
		String sqlQuery = "select review_id as review_id, beer_id as beer_id, (select cast(count(star_rating) as varchar) as review_text from reviews where beer_id = ?), (select cast(avg(star_rating) as int) as star_rating from reviews where beer_id = ?), username as username from reviews where beer_id = ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, id, id, id);
		while(theRowSet.next()) {
			Reviews returnedDetail = mapRowToReview(theRowSet);
			returnedDetails.add(returnedDetail);
		}
		return returnedDetails;
	}
	
	
	public List<Reviews> getReviewsByBeerId(int id) {
		List<Reviews> returnedDetails = new ArrayList();
		String sqlQuery = "select * from reviews where beer_id = ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, id);
		while(theRowSet.next()) {
			Reviews returnedDetail = mapRowToReview(theRowSet);
			returnedDetails.add(returnedDetail);
		}
		return returnedDetails;
	}
	
	public void addReview(Reviews aReview) {
		String newReview = "INSERT INTO reviews (beer_id, review_text, star_rating, username) " + 
						   "VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(newReview, aReview.getBeer_id(), aReview.getReview_text(), aReview.getStar_rating(), aReview.getUsername());
		
	}
	
	public void deleteReview(int reviewId) {
		String reviewDelete = "delete from reviews where review_id = ?";
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
