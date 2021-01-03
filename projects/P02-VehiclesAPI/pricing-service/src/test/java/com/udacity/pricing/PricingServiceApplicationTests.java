package com.udacity.pricing;

import org.h2.util.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;
	private String baseUrl = "http://localhost:";

	@Autowired
	private TestRestTemplate testRestTemplate;


	@Test
	public void getAllCars() {
		ResponseEntity<JSONObject> response =
				this.testRestTemplate.getForEntity(baseUrl + port + "/prices", JSONObject.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void getPriceById() {
		ResponseEntity<JSONObject> response =
				this.testRestTemplate.getForEntity(baseUrl + port + "/prices/1", JSONObject.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

	}

}
