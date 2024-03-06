package com.it_moisesmoreno.TourismAndTravelMS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeController {

	@GetMapping("")
	public String welcome() {
		System.out.println("main controller");
		return "index";
	}

}