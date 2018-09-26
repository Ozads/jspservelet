package com.softech.springmvc.web.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;

	public OffersDAO() {
		System.out.println("Hello World");
	}
	@Autowired
	public void setDataSource(DataSource jdbc) {
	this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

	return jdbc.query("select * from offers", new RowMapper<Offer>() {

	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
	Offer offer = new Offer();

	offer.setId(rs.getInt("id"));
	offer.setFirstName(rs.getString("first_name"));
	offer.setLastName(rs.getString("last_name"));
	offer.setText(rs.getString("text"));
	offer.setEmail(rs.getString("email"));

	return offer;
	}

	});
	}

	public boolean update(Offer offer) {
	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

	return jdbc.update("update offer set first_name=:firstName last_name=:lastName, text=:text, email=:email where id=:id", params) == 1;
	}

	public boolean create(Offer offer) {

	BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

	return jdbc.update("insert into offers (first_name, last_name, text, email) values (:firstName, :lastName, :text, :email)", params) == 1;
	}

	@Transactional
	public int[] create(List<Offer> offers) {

	SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

	return jdbc.batchUpdate("insert into offers (id, first_name, last_name, text, email) values (:id, :firstName, :lastName, :text, :email)", params);
	}

	public boolean delete(int id) {
	MapSqlParameterSource params = new MapSqlParameterSource("id", id);

	return jdbc.update("delete from offer where id=:id", params) == 1;
	}

	public Offer getOffer(int id) {

	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("id", id);

	return jdbc.queryForObject("select * from offer where id=:id", params,
	new RowMapper<Offer>() {

	public Offer mapRow(ResultSet rs, int rowNum)
	throws SQLException {
	Offer offer = new Offer();

	offer.setId(rs.getInt("id"));
	offer.setFirstName(rs.getString("first_name"));
	offer.setLastName(rs.getString("last_name"));
	offer.setText(rs.getString("text"));
	offer.setEmail(rs.getString("email"));

	return offer;
	}

	});
	}


}
