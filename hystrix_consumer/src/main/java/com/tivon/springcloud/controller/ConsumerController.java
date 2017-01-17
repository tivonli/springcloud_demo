package com.tivon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tivon.springcloud.service.ConsumerService;


@RestController
public class ConsumerController {

	@Autowired
	ConsumerService service;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
		return service.hello();
		
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam int num) {
		return service.add(num);
		
    }

}
