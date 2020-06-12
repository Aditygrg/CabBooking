package com.loginext.cabbooking.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loginext.cabbooking.Exception.ValidationException;
import com.loginext.cabbooking.dao.BookingFormData;
import com.loginext.cabbooking.service.CabService;

@Controller
public class CabController {
	
	@Autowired
	CabService cabService;
	
	@GetMapping("/")
	public ModelAndView getIndex() {
		System.out.println("index called");
		return new ModelAndView("index");
	}
	
	@PostMapping("/cabbook")
	public ModelAndView bookCab(@ModelAttribute("name") String name, @ModelAttribute("latitude") String latitude,
			@ModelAttribute("longitude") String longitude,Model model) {
		
		BookingFormData data = new BookingFormData(name, latitude, longitude);
		try {
			cabService.bookCab(data);
		}
		catch (ValidationException e) {
			return new ModelAndView("index","error",e.getMessage());
		}
		return printOrderData();
	}
	
	public ModelAndView printOrderData() {
		List<Object[]> orderData = cabService.getOrderData();
		//HashMap<String, Object> data = new HashMap<String, Object>();
		//data.put("data", data);
		return new ModelAndView("orderSummary","data",orderData);
	}
}
