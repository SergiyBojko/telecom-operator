package com.serhii.telecomoperator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CityCallStatisticsDTO {
	private String city;
	private long callCount;
}
