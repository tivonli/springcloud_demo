package com.tivon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

	@Autowired
    RestTemplate restTemplate;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String add() {
		System.out.println("=========================restTemplate is null ?" + (restTemplate == null));
		ResponseEntity<String> entity = restTemplate.getForEntity("http://service-provider/greeting?name=world", String.class);
        if (entity != null && entity.getStatusCodeValue() == 200) {
        	return entity.getBody();
        } else {
        	return "error occur";
        }
		
    }

}
