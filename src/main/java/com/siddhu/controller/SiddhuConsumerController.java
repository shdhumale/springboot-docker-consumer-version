package com.siddhu.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SiddhuConsumerController {
	
	@GetMapping("/getEmployee")
	public String getEmployeeDetails() {
		//String baseUrl = "http://localhost:8091/employee";
		//for docker we need to make changes in the url 
		String baseUrl = "http://siddhuproducer:8091/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.getForEntity(baseUrl,String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println("Simple data message showing success call for version client:- " + response.getBody());
		return response.getBody();
	}

	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}