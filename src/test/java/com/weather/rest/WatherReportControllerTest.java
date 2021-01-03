package com.weather.rest;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.weather.service.exception.WeatherReportServiceException;

/**
 * The Class WatherReportControllerTest consists test cases using Junit
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class WatherReportControllerTest {

	/** The port. */
	@LocalServerPort
    private int port;
	
	/** The rest template. */
	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * Gets the weather report 404 exception test.
	 *
	 * @return the weather report 404 exception test
	 * @throws RestClientException the rest client exception
	 * @throws MalformedURLException the malformed URL exception
	 * @throws WeatherReportServiceException the weather report service exception
	 */
	@Test
	public void getWeatherReport404ExceptionTest() throws RestClientException, MalformedURLException, WeatherReportServiceException {
		
		
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/weather/report/ds454?from=2020-12-24&to=2020-12-24").toString(), String.class);
		
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	/**
	 * Gets the weather report 400 exception test.
	 *
	 * @return the weather report 400 exception test
	 * @throws RestClientException the rest client exception
	 * @throws MalformedURLException the malformed URL exception
	 * @throws WeatherReportServiceException the weather report service exception
	 */
	@Test
	public void getWeatherReport400ExceptionTest() throws RestClientException, MalformedURLException, WeatherReportServiceException {
		
		
		ResponseEntity<String> response = restTemplate.getForEntity(
				new URL("http://localhost:" + port + "/weather/report/ds454?from=&to=2020-24").toString(), String.class);
		
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
}
