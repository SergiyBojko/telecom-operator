package com.serhii.telecomoperator.repository;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.model.CallInfo;

@Repository
public interface CallInfoRepo extends JpaRepository<CallInfo, Long>{
	
	@Query("SELECT new com.serhii.telecomoperator.dto.CityCallStatisticsDTO(city, count(1)) "
			+ "FROM CallInfo "
			+ "GROUP BY city")
	List<CityCallStatisticsDTO> getNumberOfCallsPerCity();
	
	CallInfoDTO findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(long cliendId, ZonedDateTime start, ZonedDateTime end);

}
