package com.jva.rnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@RequestMapping(path = "getname")
	public ResponseEntity<String> getName(@RequestBody String name) {
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}

}
