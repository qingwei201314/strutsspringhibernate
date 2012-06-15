package com.kevin.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {

	@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)
	public void test(@PathVariable String ownerId, Model model) {
		System.out.println("kevin controller");
		model.addAttribute("kevin", "displayOwner");
	}
}
