package com.tivon.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://service-provider/greeting?name=world",
				String.class);
		if (entity != null && entity.getStatusCodeValue() == 200) {
			return entity.getBody();
		} else {
			return "error occur";
		}

	}
	
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String random() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://service-provider/random",
				String.class);
		if (entity != null && entity.getStatusCodeValue() == 200) {
			return entity.getBody();
		} else {
			return "error occur";
		}

	}

	public String helloFallback() {
		return "error";
	}
}
