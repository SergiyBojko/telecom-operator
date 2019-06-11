package com.serhii.telecomoperator.service.base;

import java.time.ZonedDateTime;
import java.util.List;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.model.CallInfo;

public interface CallInfoService {
	CallInfoDTO saveCallInfo(CallInfoDTO callInfo);
	CallInfoDTO getLongestCallInDateRange (long cliendId, ZonedDateTime start, ZonedDateTime end);
	List<CityCallStatisticsDTO> getNumberOfCallsPerCity();
}
