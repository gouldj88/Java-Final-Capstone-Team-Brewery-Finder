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
import com.techelevator.application.model.BreweryDetails;

@Component
public class BreweryDetailsSQLDAO implements BreweryDetailsDAO {
	
	private JdbcTemplate jdbcTemplate;

    public BreweryDetailsSQLDAO(DataSource aDataSource) {
        this.jdbcTemplate = new JdbcTemplate(aDataSource);
    } 

	@Override
	public List<BreweryDetails> getBreweryDetailsById(String obdbId) {
		List<BreweryDetails> returnedDetails = new ArrayList();
		String sqlQuery = "select * from userbrewerydetails where obdb_id = ?";
		SqlRowSet theRowSet = jdbcTemplate.queryForRowSet(sqlQuery, obdbId);
		while(theRowSet.next()) {
			BreweryDetails returnedDetail = mapRowToBreweryDetails(theRowSet);
			returnedDetails.add(returnedDetail);
		}
		return returnedDetails;
	}
	
	@Override
	public void addBreweryDetails(BreweryDetails formData) {
		String myNewDetails = "insert into userbrewerydetails (obdb_id, history, image_url, hour_open, hour_closed, open_sun, open_mon, open_tue, open_wed, open_thu, open_fri, open_sat) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(myNewDetails, formData.getObdb_id(), formData.getHistory(), formData.getImage_url(), formData.getHour_open(), formData.getHour_closed(), formData.getOpen_sun(), formData.getOpen_mon(), formData.getOpen_tue(), formData.getOpen_wed(), formData.getOpen_thu(), formData.getOpen_fri(), formData.getOpen_sat());
	}
	
	@Override
	public void updateBreweryHistory(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set history = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getHistory(), formData.getObdb_id());
	}
	
	@Override
	public void updateBreweryImage(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set image_url = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getImage_url(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryHourOpen(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set hour_open = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getHour_open(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryHourClosed(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set hour_closed = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getHour_closed(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryOpenSun(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_sun = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_sun(), formData.getObdb_id());
	}
	
	@Override
	public void updateBreweryOpenMon(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_mon = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_mon(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryOpenTue(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_tue = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_tue(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryOpenWed(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_wed = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_wed(), formData.getObdb_id());
	}
	@Override
	public void updateBreweryOpenThu(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_thu = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_thu(), formData.getObdb_id());
	}
	
	@Override
	public void updateBreweryOpenFri(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_fri = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_fri(), formData.getObdb_id());
	}

	@Override
	public void updateBreweryOpenSat(BreweryDetails formData) {
		String myNewDetails = "update userbrewerydetails set open_sat = ? where obdb_id = ?";
		jdbcTemplate.update(myNewDetails, formData.getOpen_sat(), formData.getObdb_id());
	}

	
    private BreweryDetails mapRowToBreweryDetails(SqlRowSet rs) {
       
    	BreweryDetails details = new BreweryDetails();
    	details.setObdb_id(rs.getString("obdb_id"));
    	details.setHistory(rs.getString("history"));
    	details.setHour_open(rs.getString("hour_open"));
    	details.setHour_closed(rs.getString("hour_closed"));
    	details.setOpen_sun(rs.getBoolean("open_sun"));
    	details.setOpen_mon(rs.getBoolean("open_mon"));
    	details.setOpen_tue(rs.getBoolean("open_tue"));
    	details.setOpen_wed(rs.getBoolean("open_wed"));
    	details.setOpen_thu(rs.getBoolean("open_thu"));
    	details.setOpen_fri(rs.getBoolean("open_fri"));
    	details.setOpen_sat(rs.getBoolean("open_sat"));
        return details;
    }
}
