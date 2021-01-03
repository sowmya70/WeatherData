package com.weather.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.constants.ApplicationConstants;
import com.weather.dto.WeatherRepository;
import com.weather.dto.model.WeatherDetails;
import com.weather.service.exception.WeatherReportServiceException;

/**
 * The Class WeatherReportService is service to provide the business logic to return weather details 
 */
@Service
public class WeatherReportService {

	/** The weather repo. */
	@Autowired
	private WeatherRepository weatherRepo;
	
	/** The formatter. */
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/**
	 * Gets the weather report.
	 *
	 * @param zipCode the zip code
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the weather report
	 * @throws WeatherReportServiceException the weather report service exception
	 */
	public List<WeatherDetails> getWeatherReport(String zipCode, String fromDate, String toDate) throws WeatherReportServiceException {
		
		List<WeatherDetails> weatherDetails = weatherRepo.findByZipCodeAndDateBetween(zipCode,parseDate(fromDate), 
				parseDate(toDate));
		if(weatherDetails.isEmpty()) {
			
			throw new WeatherReportServiceException(2,ApplicationConstants.DATA_NOT_FOUND);
		}
		return weatherDetails;
	}
	
	/**
	 * Parses the date.
	 *
	 * @param date the date
	 * @return the local date
	 * @throws WeatherReportServiceException the weather report service exception
	 */
	private LocalDate parseDate(String date) throws WeatherReportServiceException {
		try {
			
			return LocalDate.parse(date, formatter);
		}catch(DateTimeParseException ex) {
			
			throw new WeatherReportServiceException(1,ApplicationConstants.INVALID_DATE); 
		}
	}
}
