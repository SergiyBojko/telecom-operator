package com.serhii.telecomoperator.dto;

import java.time.ZonedDateTime;

import com.serhii.telecomoperator.model.CallInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CallInfoDTO {
	
	private long id;
	private long clientId;
	private String callersPhone;
	private String recipientsPhone;
	private ZonedDateTime callTime;
	private long callDurationMills;
	private String city;
	
	public CallInfoDTO(CallInfo callInfo) {
		id = callInfo.getId();
		clientId = callInfo.getClientId();
		callersPhone = callInfo.getCallersPhone();
		recipientsPhone = callInfo.getRecipientsPhone();
		callTime = callInfo.getCallTime();
		callDurationMills = callInfo.getCallDurationMills();
		city = callInfo.getCity();
	}

}
