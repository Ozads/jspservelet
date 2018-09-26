package com.softech.springmvc.web.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softech.springmvc.web.DAO.Offer;
import com.softech.springmvc.web.Service.OffersService;

@Controller
public class OfflinkController {
	
	private OffersService offersService;
	

@Autowired
public void setOffersService(OffersService offersService) {
	this.offersService=offersService;
}


	
	@RequestMapping("/showoffers")
	public String showOffer(Model model) {
		
		List<Offer> offers =offersService.getCurrent();
		model.addAttribute("offers",offers);
		return"showoffers";
	}
	
	@RequestMapping("/addoffer")
	public String addOffer() {
		return"addoffer";
	}
	
	@RequestMapping(value="/tests", method=RequestMethod.GET)
	public String showtest(Model model, @RequestParam("id") String id) {
		System.out.println("ID:"+id);
		return "home";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Form does not validate.");

			List<ObjectError> errors = result.getAllErrors();

			for(ObjectError error: errors) {
			System.out.println(error.getDefaultMessage());
			}
			}
			else {
			System.out.println(offer);
			}

			return "offercreated";
			
		
		
	}
}
