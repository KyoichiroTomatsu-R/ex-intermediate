package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテルのリポジトリクラスを扱うサービスクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	/**
	 * 全件検索.
	 * @return 全てのホテル
	 */
	public List<Hotel> findAll(){
		return hotelRepository.findAll();
	}
	
	/**
	 *  指定の値以下の値段のホテル検索.
	 * @param price　検索値段
	 * @return　検索されたホテル
	 */
	public List<Hotel> serchByLessThanPrice(int price){
		return hotelRepository.SerchPrice(price);
	}
	
	
}
