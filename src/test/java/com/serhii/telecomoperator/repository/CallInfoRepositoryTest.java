package com.serhii.telecomoperator.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.model.CallInfo;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest
public class CallInfoRepositoryTest {
	
	private static boolean isSetupDone;
	
	private CallInfo ci1, ci2, ci3;
	
	@Autowired
	private CallInfoRepo callInfoRepo;
	
	@Before
	public void setup() {
		if (isSetupDone) {
			return;
		}
		ci1 = new CallInfo(0, 1, "1111", "2222", ZonedDateTime.now(), 10000, "Kyiv");
		ci2 = new CallInfo(0, 1, "1111", "3333", ZonedDateTime.now(), 20000, "Kyiv");
		ci3 = new CallInfo(0, 2, "2222", "1111", ZonedDateTime.now(), 10000, "Lviv");
		ci1 = callInfoRepo.save(ci1);
		ci2 = callInfoRepo.save(ci2);
		ci3 = callInfoRepo.save(ci3);
		isSetupDone = true;
	}

	@Test
	public void shouldReturnLongestCallForSpecifiedClientAndDateRange() {
		CallInfoDTO actual = callInfoRepo.findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(
				1, 
				ZonedDateTime.now().minusHours(1), 
				ZonedDateTime.now().plusHours(1));
		
		assertNotNull(actual);
		assertEquals(ci2.getId(), actual.getId());
	}
	
	@Test
	public void shouldReturnNullIfNoCallsComplyForSpecifiedClientOrDateRange() {
		CallInfoDTO actual1 = callInfoRepo.findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(
				3, 
				ZonedDateTime.now().minusHours(1), 
				ZonedDateTime.now().plusHours(1));
		
		CallInfoDTO actual2 = callInfoRepo.findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(
				1, 
				ZonedDateTime.now().plusHours(1), 
				ZonedDateTime.now().plusHours(2));
		
		assertNull(actual1);
		assertNull(actual2);
	}
	
	@Test
	public void shouldReturnCorrectCountOfCallsPerCity() {
		List<CityCallStatisticsDTO> actualCityStats = callInfoRepo.getNumberOfCallsPerCity();
		
		assertEquals(2, actualCityStats.size());
		
		for (CityCallStatisticsDTO cityStats : actualCityStats) {
			switch (cityStats.getCity()) {
			case "Kyiv":
				assertEquals(2, cityStats.getCallCount());
				break;
			case "Lviv":
				assertEquals(1, cityStats.getCallCount());
				break;
			default:
				assertTrue("Unexpected city name", false);
			}
		}
	}
}
