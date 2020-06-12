package com.loginext.cabbooking.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.loginext.cabbooking.Exception.ValidationException;
import com.loginext.cabbooking.dao.BookingFormData;
import com.loginext.cabbooking.entity.BookOrder;
import com.loginext.cabbooking.entity.Driver;
import com.loginext.cabbooking.repository.BookOrderRepository;
import com.loginext.cabbooking.repository.DriverRepository;
import com.loginext.cabbooking.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	DriverRepository driverRepository;
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	BookOrderRepository bookOrderRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void bookCab(BookingFormData bookingFormData) {
		BookingFormData.validate(bookingFormData);
		BigDecimal lat = new BigDecimal(bookingFormData.getLatitude());
		BigDecimal lon = new BigDecimal(bookingFormData.getLongitude());
		
		Long driverId = null;
		String query = "select id from (select NVL(3963,0) * ACOS((sin(NVL("+lat+",0) / 57.29577951) * SIN(NVL(Latitude,0) / 57.29577951)) + (COS(NVL("+lat+",0) / 57.29577951) * COS(NVL(latitude,0) / 57.29577951) * COS(NVL(longitude,0) / 57.29577951 - NVL("+lon+",0)/ 57.29577951))) as distance,id from Driver where status = 1) outer order by distance fetch first 1 rows only";
		try {
			driverId = template.queryForObject(query, Long.class);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ValidationException("Driver not available");
		}
		
		Optional<Driver> driver = driverRepository.findById(driverId);
		
		if(driver.isPresent()) {
			driver.get().setStatus(false);
			BookOrder order = new BookOrder(bookingFormData.getName(),lat,lon,driver.get());
			bookOrderRepository.save(order);
		}
		else {
			throw new ValidationException("Driver not available");
		}
		
	}

	@Override
	public List<Object[]> getOrderData() {
		return bookOrderRepository.getOrderSummary();
	}
	

}
