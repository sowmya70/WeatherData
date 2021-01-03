package com.weather.dto.model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class WeatherDetails is mapping to the table weather_details in data storage
 */
@Entity
@Table(name = "weather_details")
public class WeatherDetails {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/** The zip code. */
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	/** The date. */
	private LocalDate date;
	
	/** The weather data. */
	@Column(name = "average_temperature")
	private String avarageTemperature;
	
	/** The climate. */
	private String climate;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the zip code.
	 *
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Gets the avarage temperature.
	 *
	 * @return the avarageTemperature
	 */
	public String getAvarageTemperature() {
		return avarageTemperature;
	}
	
	/**
	 * Sets the avarage temperature.
	 *
	 * @param avarageTemperature the avarageTemperature to set
	 */
	public void setAvarageTemperature(String avarageTemperature) {
		this.avarageTemperature = avarageTemperature;
	}
	
	/**
	 * Gets the climate.
	 *
	 * @return the climate
	 */
	public String getClimate() {
		return climate;
	}
	
	/**
	 * Sets the climate.
	 *
	 * @param climate the climate to set
	 */
	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	
}
