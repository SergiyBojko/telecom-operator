package com.serhii.telecomoperator.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.model.CallInfo;
import com.serhii.telecomoperator.repository.CallInfoRepo;
import com.serhii.telecomoperator.service.base.CallInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallInfoServiceTest {
	
	@MockBean
	private CallInfoRepo callInfoRepo;

	@Autowired
	private CallInfoService callInfoService;
	
	private CallInfoDTO callInfoDTO;
	private CallInfo callInfo;
	private List<CityCallStatisticsDTO> cityStats;
	
	@Before
	public void setup() {
		ZonedDateTime now = ZonedDateTime.now();
		callInfoDTO = new CallInfoDTO(10, 1, "1111", "2222", now, 10000, "Kyiv");
		callInfo = new CallInfo(10, 1, "1111", "2222", now, 10000, "Kyiv"); 
		cityStats = new ArrayList<CityCallStatisticsDTO>();
		cityStats.add(new CityCallStatisticsDTO("Kyiv", 150));
		
		Mockito.when(callInfoRepo.findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(Mockito.anyLong(), Mockito.any(ZonedDateTime.class), Mockito.any(ZonedDateTime.class)))
				.thenReturn(callInfoDTO);
		Mockito.when(callInfoRepo.getNumberOfCallsPerCity())
				.thenReturn(cityStats);
		Mockito.when(callInfoRepo.save(callInfo))
				.thenReturn(callInfo);
	}
	
	@Test
	public void shouldReturnCityStatistics() {
		List<CityCallStatisticsDTO> actual = callInfoService.getNumberOfCallsPerCity();
		
		assertEquals(cityStats.get(0), actual.get(0));
	}
	
	@Test
	public void shouldReturnTopPhoneCall() {
		CallInfoDTO actual = callInfoService.getLongestCallInDateRange(1, ZonedDateTime.now(), ZonedDateTime.now());
		
		assertEquals(callInfoDTO, actual);
	}
	
	@Test
	public void shoulSaveCallInfo() {
		CallInfoDTO result = callInfoService.saveCallInfo(callInfoDTO);
		
		assertEquals(result, callInfoDTO);
		verify(callInfoRepo).save(callInfo);
	}
}
