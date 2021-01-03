package com.weather.service.exception;

/**
 * The Class WeatherReportServiceException is to throw exception from service for irregular execution
 */
public class WeatherReportServiceException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The err code. */
	private int errCode;

	/**
	 * Instantiates a new weather report service exception.
	 *
	 * @param errCode the err code
	 * @param errMsg the err msg
	 */
	public WeatherReportServiceException(int errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	/**
	 * Gets the err code.
	 *
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}
	
	
}
