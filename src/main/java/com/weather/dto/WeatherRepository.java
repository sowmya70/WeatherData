package com.weather.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.dto.model.WeatherDetails;

/**
 * The Interface WeatherRepository contains all CRUD operation details for weather_details table.
 */
@Repository
public interface WeatherRepository extends JpaRepository<WeatherDetails, Integer>{

	
	/**
	 * Find by zip code and date between.
	 *
	 * @param zipCode the zip code
	 * @param fromData the from data
	 * @param toDate the to date
	 * @return the list
	 */
	List<WeatherDetails> findByZipCodeAndDateBetween(String zipCode, LocalDate fromData, LocalDate toDate);
}
