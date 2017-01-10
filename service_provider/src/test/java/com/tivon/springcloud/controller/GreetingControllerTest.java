package com.tivon.springcloud.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class GreetingControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testExample() throws Exception {
		int param = 1;
		ResponseEntity<Integer> result = this.restTemplate.getForEntity("/add?num=" + param, Integer.class);

		assertThat(result.getBody()).isEqualTo(param + 1);
	}

}
