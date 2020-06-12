package com.loginext.cabbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.loginext.cabbooking.entity.BookOrder;

public interface BookOrderRepository  extends CrudRepository<BookOrder, Long>{
	
	@Query(value = "select d.name,b.cust_name,d.status from driver d left outer join book_order b on b.driver_id = d.id", nativeQuery = true)
	public List<Object[]> getOrderSummary();

}
