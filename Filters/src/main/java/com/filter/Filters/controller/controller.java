package com.filter.Filters.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class controller {

	@RequestMapping("/hello")
	public String helloWorld(){
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping("/another-url")
	public String anotherUrl(){
		return "<h1>Amother URL</h1>";
	}
	
	@RequestMapping("/hi")
	public String hi(){
		return "<h1>Hi</h1>";
	}
}
