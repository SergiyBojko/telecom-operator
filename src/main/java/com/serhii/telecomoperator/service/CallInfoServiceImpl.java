package com.serhii.telecomoperator.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.model.CallInfo;
import com.serhii.telecomoperator.repository.CallInfoRepo;
import com.serhii.telecomoperator.service.base.CallInfoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CallInfoServiceImpl implements CallInfoService{
	
	private CallInfoRepo callInfoRepo;

	@Override
	public CallInfoDTO saveCallInfo(CallInfoDTO callInfo) {
		CallInfo saved = callInfoRepo.save(new CallInfo(callInfo));
		return new CallInfoDTO(saved);
	}

	@Override
	public CallInfoDTO getLongestCallInDateRange(long clientId, ZonedDateTime start, ZonedDateTime end) {
		return callInfoRepo.findTopByClientIdAndCallTimeBetweenOrderByCallDurationMillsDesc(clientId, start, end);
	}

	@Override
	public List<CityCallStatisticsDTO> getNumberOfCallsPerCity() {
		return callInfoRepo.getNumberOfCallsPerCity();
	}
	
	
}
