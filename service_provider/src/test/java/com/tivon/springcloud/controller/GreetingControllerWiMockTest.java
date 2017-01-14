package com.tivon.springcloud.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tivon.springcloud.service.GreetingService;

@RunWith(SpringRunner.class)
// 启动内置tomcat需要指定webEnvironment参数
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, properties="classpath:config/config-test.properties")
public class GreetingControllerWiMockTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private GreetingService service;

	@Test
	public void testExample() throws Exception {
		int param = 1;

		// 假设service.addOne服务在单元测试期间不可用,同时目的并不是测试addOne服务,则可以给个假的返回结果
		given(this.service.addOne(param)).willReturn(param + 2);

		// 此接口依赖于service.addOne接口
		ResponseEntity<Integer> result = this.restTemplate.getForEntity("/add?num=" + param, Integer.class);

		assertThat(result.getBody()).isEqualTo(param + 2);

	}

}
