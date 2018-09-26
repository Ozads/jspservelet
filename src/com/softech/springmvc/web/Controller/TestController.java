package com.softech.springmvc.web.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
@RequestMapping("/model")
public String getHello(Model model) {
	model.addAttribute("name1", "<b>OZADS</b>");
	return "modeltest";
}

@RequestMapping("/session")
public String getHello(HttpSession session) {
	session.setAttribute("name", "Ozads");
	return"test";
}

@RequestMapping("/modelandview")
public ModelAndView getHello() {
	ModelAndView mv=new ModelAndView("modelandviewtest");
	Map<String,Object> model=mv.getModel();
	model.put("name","<b><u>SPRING</b></u>");
	return mv;
	
}

}
