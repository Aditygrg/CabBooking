package com.loginext.cabbooking.dao;

import com.loginext.cabbooking.Exception.ValidationException;

public class BookingFormData {
	private static final String LATITUDE_PATTERN="^(([1-8]?[0-9])(\\.[0-9]{1,9})?|90(\\.0{1,9})?)$";
	private static final String LONGITUDE_PATTERN="^((([1-9]?[0-9]|1[0-7][0-9])(\\.[0-9]{1,9})?)|180(\\.0{1,9})?)$";
	
	private String name;
	
	private String latitude;
	
	private String longitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public BookingFormData(String name, String latitude, String longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "BookingFormData [name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	public static boolean validate(BookingFormData bookingFormData) {
		if(bookingFormData.getName() == null || bookingFormData.getName().isEmpty()) {
			throw new ValidationException("Name should not be empty!!!");
		}
		if(!bookingFormData.getName().matches("^[a-zA-Z]*")){
			throw new ValidationException("Name should contain characters only!!!");
		}
		if(bookingFormData.getLatitude() == null || bookingFormData.getLatitude().isEmpty()) {
			throw new ValidationException("Latitude should not be empty!!!");
		}
		if(bookingFormData.getLongitude() == null || bookingFormData.getLongitude().isEmpty()) {
			throw new ValidationException("Longitude should not be empty!!!");
		}
		if(!bookingFormData.getLatitude().matches(LATITUDE_PATTERN)) {
			throw new ValidationException("Invalid latitude!!!");
		}
		if(!bookingFormData.getLatitude().matches(LONGITUDE_PATTERN)) {
			throw new ValidationException("Invalid longitude!!!");
		}
		return true;
	}
}
