package com.tivon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tivon.springcloud.service.HelloService;


@RestController
public class ConsumerController {

	@Autowired
	HelloService service;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
		return service.hello();
		
    }
	
	@RequestMapping(value = "/random", method = RequestMethod.GET)
    public String random() {
		return service.random();
		
    }

}
