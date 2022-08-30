package com.tts.weatherapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.weatherapp.models.Request;
import com.tts.weatherapp.models.Response;
import com.tts.weatherapp.services.WeatherService;

@Controller
public class WeatherController {

	//We want a copy of WeatherService
	@Autowired
	private WeatherService weatherService;
	
	//In Spring Boot we are frequently not going to construct
	//our own objects. Instead we are going to tell Spring
	//boot how to make an object, and later we can 
	//just ask Spring Boot for an object, and we don't
	//have to instantiate it ourselves...we just 
	//use the @Autowired annotation to ask for the objects.
	
	@GetMapping(path="/")
	public String getIndex(Model model) {		
		Request request = new Request();
		model.addAttribute("request", request);					
		return "index";
	}
	
	@PostMapping(path="/")
	public String postIndex(Request request, Model model) {
		Response response = weatherService.getForecast(request.getZipCode());
		model.addAttribute("data", response);
		return "index";
	}
	
	
	
	
	
	
	
	
	
}
