package com.example.demo;

import com.example.demo.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test message");

		//Text JSON -> Object
		// Object -> Text JSON
		var objectMapper = new ObjectMapper();


		//object mapper
		// object -> text 는 getter를 사용한다. (get method)
		var user = new User("Steve",49,"010-2352-2312");

		String text = null;
		try {
			text = objectMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		System.out.println(text);


		// text -> object는 default 생성자를 필요로 한다.
		User objectUser = null;
		try {
			objectUser = objectMapper.readValue(text, User.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		System.out.println(objectUser);
	}

}
