package com.example.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@ModelAttribute
	public HotelForm setUpForm() {
		return new HotelForm();
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "hotel.html";
	}

	@RequestMapping("/search")
	public String serch(@Validated HotelForm form, BindingResult result,RedirectAttributes redirectAttributes, Model model) {
		
		if(result.hasErrors()) {
			return index(model);
		}
		
		if(form.getPrice().isEmpty() == true) {
			model.addAttribute("hotelList", hotelService.findAll());
		} else {
			model.addAttribute("hotelList", hotelService.serchByLessThanPrice(Integer.parseInt(form.getPrice())));
		}

		return "hotel.html";
	}

}
