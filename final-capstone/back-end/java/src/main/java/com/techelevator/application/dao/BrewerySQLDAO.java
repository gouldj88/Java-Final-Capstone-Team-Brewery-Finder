package com.techelevator.application.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.application.model.Brewery;

public class BrewerySQLDAO implements BreweryDAO {
	private JdbcTemplate jdbcTemplate;

    public BrewerySQLDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public Brewery getBreweryByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brewery getBreweryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brewery getBreweryByCityState(String city, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brewery getBreweryByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brewery getBreweryByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}
    
	

}
