package com.weather.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.weather.constants.ApplicationConstants;
import com.weather.dto.model.WeatherDetails;
import com.weather.service.WeatherReportService;
import com.weather.service.exception.WeatherReportServiceException;

/**
 * The Class WeatherReportController is to accept the request to respond with weather data for requested parameters
 */
@RestController
public class WeatherReportController {

	/** The weather report service. */
	@Autowired
	private WeatherReportService weatherReportService;
	
	/**
	 * Gets the weather report.
	 *
	 * @param zipCode the zip code
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the weather report
	 */
	@GetMapping("/weather/report/{zipcode}")
	public List<WeatherDetails> getWeatherReport(@PathVariable(value = "zipcode",required = false) String zipCode, 
			@RequestParam(value = "from",required = false) String fromDate, 
			@RequestParam(value = "to",required = false) String toDate) {
		try {
			
			validateParams(zipCode,fromDate,toDate);
			return weatherReportService.getWeatherReport(zipCode, fromDate, toDate);
		} catch(WeatherReportServiceException ex) {
			if(ex.getErrCode() == 1) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			}
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	/**
	 * Validate params.
	 *
	 * @param zipCode the zip code
	 * @param fromDate the from date
	 * @param toDate the to date
	 */
	private void validateParams(String zipCode, String fromDate, String toDate) {
		
		if(!StringUtils.hasText(zipCode) || !StringUtils.hasText(fromDate) || !StringUtils.hasText(toDate)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApplicationConstants.INVALID_PARAMETERS);
		}
	}
}
