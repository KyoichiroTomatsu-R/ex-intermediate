package com.example.form;

import javax.validation.constraints.Pattern;

/**
 * ホテルを表すフォームクラス.
 * 
 * @author kyoichiro.tomatsu
 *
 */
public class HotelForm {

	/** 値段 */
	@Pattern(regexp="^\\d{0,7}$?",message="数字を入れてください")
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}

}
