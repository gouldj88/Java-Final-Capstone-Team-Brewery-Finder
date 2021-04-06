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

import com.techelevator.application.model.Brewery;

@Component
public class BrewerySQLDAO implements BreweryDAO {
	
	private JdbcTemplate jdbcTemplate;

    public BrewerySQLDAO(DataSource aDataSource) {
        this.jdbcTemplate = new JdbcTemplate(aDataSource);
    } 

	@Override
	public List<Brewery> getBreweriesByZipCode(String zipCode) {
		List<Brewery> returnedBreweries = new ArrayList();
		String sqlQuery = "select * from breweries where postal_code like ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, zipCode+"%");
		while(theRowSet.next()) {
			Brewery returnedBrewery = mapRowToBrewery(theRowSet);
			returnedBreweries.add(returnedBrewery);
		}
		return returnedBreweries;
	}

	@Override
	public List<Brewery> getBreweriesByName(String name) {
		List<Brewery> returnedBreweries = new ArrayList();
		String sqlQuery = "select * from breweries where lower(name) like ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, "%"+name.toLowerCase()+"%");
		while(theRowSet.next()) {
			Brewery returnedBrewery = mapRowToBrewery(theRowSet);
			returnedBreweries.add(returnedBrewery);
		}
		return returnedBreweries;
	}

	@Override
	public List<Brewery> getBreweriesByCity(String city) {
		List<Brewery> returnedBreweries = new ArrayList();
		String sqlQuery = "select * from breweries where lower(city) like ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, "%"+city.toLowerCase()+"%");
		while(theRowSet.next()) {
			Brewery returnedBrewery = mapRowToBrewery(theRowSet);
			returnedBreweries.add(returnedBrewery);
		}
		return returnedBreweries;
	}

	@Override
	public List<Brewery> getBreweriesByState(String state) {
		List<Brewery> returnedBreweries = new ArrayList();
		String sqlQuery = "select * from breweries where lower(state) like ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, "%"+state.toLowerCase()+"%");
		while(theRowSet.next()) {
			Brewery returnedBrewery = mapRowToBrewery(theRowSet);
			returnedBreweries.add(returnedBrewery);
		}
		return returnedBreweries;
	}
	
	@Override
	public void createNewBrewery(String name, String street, String city, String state, 
			 String postal_code, String website_url, String phone) {
		String obdb_id_spaces = name.replaceAll("\\s","-");
		String obdb_id_punctuation = obdb_id_spaces.replaceAll("\\p{Punct}", "");
		String obdb_id = obdb_id_punctuation.toLowerCase();
		String myNewBrewery = "insert into breweries (obdb_id, name, street, city, state, postal_code, website_url, phone) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(myNewBrewery, obdb_id, name, street, city, state, postal_code, website_url, phone);
	}
	
    private Brewery mapRowToBrewery(SqlRowSet rs) {
       
    	Brewery brewery = new Brewery();
        brewery.setObdb_id(rs.getString("obdb_id"));
		brewery.setName(rs.getString("name"));
		brewery.setBrewery_type(rs.getString("brewery_type"));
		brewery.setStreet(rs.getString("street"));
		brewery.setAddress_2(rs.getString("address_2"));
		brewery.setAddress_3(rs.getString("address_3"));
		brewery.setCity(rs.getString("city"));
		brewery.setState(rs.getString("state"));
		brewery.setCounty_province(rs.getString("county_province"));
		brewery.setPostal_code(rs.getString("postal_code"));
		brewery.setWebsite_url(rs.getString("website_url"));
		brewery.setPhone(rs.getString("phone"));
		brewery.setCreated_at(rs.getDate("created_at"));
		brewery.setUpdated_at(rs.getDate("updated_at"));
		brewery.setCountry(rs.getString("country"));
		brewery.setLongitude(rs.getString("longitude"));
		brewery.setLatitude(rs.getString("latitude"));
		brewery.setTags(rs.getString("tags"));
        return brewery;
    }
}
