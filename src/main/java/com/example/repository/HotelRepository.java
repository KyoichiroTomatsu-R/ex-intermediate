package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテルテーブルを操作するリポジトリクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** マッパー */
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);
	
	
	/**
	 * 全件検索.
	 * 
	 * @return 全てのホテル
	 */
	public List<Hotel>findAll(){
		
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels ORDER BY price DESC";
		List<Hotel> hotelList = template.query(sql,HOTEL_ROW_MAPPER);
	
		return hotelList;
	}
	
	/**
	 * 指定の値以下の値段のホテル検索.
	 * 
	 * @param price 検索値段
	 * @return　検索されたホテル
	 */
	public List<Hotel> SerchPrice(int price){
		
		String sql = "SELECT  id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price <= :price ORDER BY price DESC";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql,param,HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	
	
}
