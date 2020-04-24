package com.example.demo;


import java.util.HashMap;

import java.util.Map;


import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/send")

public class userController {

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> createUser(@RequestBody recData userDetails) {
		inputData d = new inputData();
		System.out.println("THE GIVEN DATA  " + userDetails);
		d.setGenre(userDetails.getGenre());
		d.setExp(userDetails.getExp());
		d.setStream(userDetails.getStream());
		Map<String, String> out = new HashMap<String, String>(d.getOut());
		return out;
	}

	@PostMapping(path = "/random", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Map<String, String> randomReturn() {
		randomizer d = new randomizer();
		Map<String, String> out = new HashMap<String, String>(d.getOutrand());
		return out;
	}

}
