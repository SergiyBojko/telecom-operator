package com.serhii.telecomoperator.model;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.serhii.telecomoperator.dto.CallInfoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class CallInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	private String callersPhone;
	private String recipientsPhone;
	private ZonedDateTime callTime;
	private long callDurationMills;
	private String city;
	
	public CallInfo(CallInfoDTO callInfo) {
		id = callInfo.getId();
		client = new Client(callInfo.getClientId());
		callersPhone = callInfo.getCallersPhone();
		recipientsPhone = callInfo.getRecipientsPhone();
		callTime = callInfo.getCallTime();
		callDurationMills = callInfo.getCallDurationMills();
		city = callInfo.getCity();
	}
}
