package com.loginext.cabbooking.repository;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.loginext.cabbooking.entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long>{

	@Query(value = "select id from (select NVL(3963,0) * ACOS((sin(NVL(:Lat1,0) / 57.29577951) * SIN(NVL(Latitude,0) / 57.29577951)) + (COS(NVL(:Lat1,0) / 57.29577951) * COS(NVL(latitude,0) / 57.29577951) * COS(NVL(longitude,0) / 57.29577951 - NVL(:Lon1,0)/ 57.29577951))) as distance,id from Driver where status = 1) outer order by distance where fetch first one rows only",nativeQuery = true)
	public Long getNearestDriver(@Param("Lat1") BigDecimal custLat,@Param("Lon1") BigDecimal custLong);
}
