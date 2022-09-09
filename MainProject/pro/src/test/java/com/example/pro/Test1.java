package com.example.pro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class Test1 {
@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void adding_New_Farmer_Succesfully() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/farmer/addnewfarmer_v3?name=sandepp_rr&age=24&gender=Male",
				String.class)).contains("New farmer added successfully");
	}
}
