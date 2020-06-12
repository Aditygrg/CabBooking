package com.loginext.cabbooking.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookOrder")
public class BookOrder {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "CUST_NAME")
	private String custName;
	
	@Column(name = "CUST_LATITUDE", scale = 10)
	private BigDecimal custLatitude;
	
	@Column(name = "CUST_LONGITUDE", scale = 10)
	private BigDecimal custLongitude;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driver_id") private Driver driver;


	public BookOrder() {
		
	}
	
	
	public BookOrder(String custName, BigDecimal custLatitude, BigDecimal custLongitude, Driver driver) {
		super();
		this.custName = custName;
		this.custLatitude = custLatitude;
		this.custLongitude = custLongitude;
		this.driver = driver;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public BigDecimal getCustLatitude() {
		return custLatitude;
	}


	public void setCustLatitude(BigDecimal custLatitude) {
		this.custLatitude = custLatitude;
	}


	public BigDecimal getCustLongitude() {
		return custLongitude;
	}


	public void setCustLongitude(BigDecimal custLongitude) {
		this.custLongitude = custLongitude;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	public Long getId() {
		return id;
	}
	 
	

}
