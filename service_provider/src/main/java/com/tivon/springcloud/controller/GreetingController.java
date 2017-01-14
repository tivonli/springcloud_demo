package com.tivon.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tivon.springcloud.service.GreetingService;
import com.tivon.springcloud.vo.Greeting;

@RefreshScope
@RestController
public class GreetingController {
	
	@Value("${from}")
    private String from;

	@Autowired
	GreetingService service;

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return service.greeting(name);
    }
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public int addOne(@RequestParam int num) {
    	return service.addOne(num);
    }
    
    @RequestMapping(value="/config", method=RequestMethod.GET)
    public String config() {
    	return from;
    }
}
