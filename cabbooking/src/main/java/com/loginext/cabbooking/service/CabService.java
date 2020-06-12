package com.loginext.cabbooking.service;

import java.util.List;

import com.loginext.cabbooking.dao.BookingFormData;

public interface CabService {

	public void bookCab(BookingFormData bookingFormData);
	
	public List<Object[]> getOrderData();
}
