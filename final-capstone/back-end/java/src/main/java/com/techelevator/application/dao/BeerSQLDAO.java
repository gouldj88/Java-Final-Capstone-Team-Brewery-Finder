package com.techelevator.application.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.application.model.Beer;
import com.techelevator.application.model.Brewery;

@Component
public class BeerSQLDAO implements BeerDAO {
	
	private JdbcTemplate jdbcTemplate;

    public BeerSQLDAO(DataSource aDataSource) {
        this.jdbcTemplate = new JdbcTemplate(aDataSource);
    }
    
    @Override
    public List<Beer> getBeerListByBrewery(String obdbId) {
		List<Beer> returnedBeers = new ArrayList();
		String sqlQuery = "select * from beers where obdb_id = ? order by beer_name asc";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, obdbId);
		while(theRowSet.next()) {
			Beer returnedBeer = mapRowToBeer(theRowSet);
			returnedBeers.add(returnedBeer);
		}
		return returnedBeers;
	}

	@Override
	public List<Beer> getSingleBeerInfo(String beerId) {
		Integer convertedId = Integer.parseInt(beerId);
		List<Beer> returnedBeer = new ArrayList();
		String sqlQuery = "select * from beers where beer_id = ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, convertedId);
		while(theRowSet.next()) {
			Beer oneReturnedBeer = mapRowToBeer(theRowSet);
			returnedBeer.add(oneReturnedBeer);
		}
		return returnedBeer;
	}
	
	public void addABeer(Beer formData) {
		String myNewBeer = "insert into beers (obdb_id, beer_name, brewery, description, image, abv, beer_type, active) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(myNewBeer, formData.getObdb_id(), formData.getName(), formData.getBrewery(), formData.getDescription(), formData.getImage(), formData.getAbv(), formData.getType(), formData.getActive());
	}
	
	public void deleteABeer(String beerId) {
		Integer convertedId = Integer.parseInt(beerId);
		String beerDeleter = "delete from beers where beer_id = ?";
		jdbcTemplate.update(beerDeleter, convertedId);
	}
	
    private Beer mapRowToBeer(SqlRowSet rs) {
    	Beer beer = new Beer();
		beer.setBeer_id(rs.getString("beer_id"));
		beer.setObdb_id(rs.getString("obdb_id"));
		beer.setName(rs.getString("beer_name"));
		beer.setBrewery(rs.getString("brewery"));
		beer.setDescription(rs.getString("description"));
		beer.setImage(rs.getString("image"));
		beer.setAbv(rs.getString("abv"));
		beer.setType(rs.getString("beer_type"));
		beer.setActive(rs.getString("active"));
        return beer;

    }
}