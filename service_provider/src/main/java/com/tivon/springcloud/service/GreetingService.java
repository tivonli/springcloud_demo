package com.tivon.springcloud.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tivon.springcloud.vo.Greeting;

@Service
public class GreetingService {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public Greeting greeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	public int addOne(@RequestParam int num) {
		return num + 1; // for unit testing
	}
}
