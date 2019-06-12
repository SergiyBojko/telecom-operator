package com.serhii.telecomoperator.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
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
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssX")
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
