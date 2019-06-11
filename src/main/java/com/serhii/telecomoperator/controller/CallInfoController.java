package com.serhii.telecomoperator.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serhii.telecomoperator.dto.CallInfoDTO;
import com.serhii.telecomoperator.dto.CityCallStatisticsDTO;
import com.serhii.telecomoperator.service.base.CallInfoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/callinfo")
public class CallInfoController {

	private CallInfoService callInfoService;
	
	@PostMapping
	CallInfoDTO save(@RequestBody CallInfoDTO callInfo) {
		return callInfoService.saveCallInfo(callInfo);
	}
	
	@GetMapping("/longest")
	CallInfoDTO getLongestCallInDateRange (
			@RequestParam(name = "client_id") long clientId,
			@RequestParam(name = "start") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX") ZonedDateTime start,
			@RequestParam(name = "end") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX") ZonedDateTime end) {
		
		return callInfoService.getLongestCallInDateRange(clientId, start, end);
	}
	
	@GetMapping("/perCity")
	List<CityCallStatisticsDTO> getNumberOfCallsPerCity(){
		return callInfoService.getNumberOfCallsPerCity();
	}
}
