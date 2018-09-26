package com.softech.springmvc.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softech.springmvc.web.DAO.Offer;
import com.softech.springmvc.web.Service.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	

@Autowired
public void setOffersService(OffersService offersService) {
	this.offersService=offersService;
}



@RequestMapping("/disp")
public String showHome(Model model) {
	List<Offer> offers=offersService.getCurrent();
	model.addAttribute("offers", offers);
	return "disp";
}



@RequestMapping("/student")
public String showStudent() {
	return "student";
	
}

@RequestMapping("/class")
public String showClass() {
	return "class";
	
}


@RequestMapping("/home")
public String showFirst() {
	return "home";
}

}
