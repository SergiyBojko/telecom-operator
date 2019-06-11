package com.serhii.telecomoperator.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serhii.telecomoperator.model.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClientDTO {
	
	private long id;
	private String fullName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate birthday;
	private String gender;
	private List<String> phones;
	
	public ClientDTO (Client client) {
		id = client.getId();
		fullName = client.getFullName();
		birthday = client.getBirthday();
		gender = client.getGender().toString();
		phones = client.getPhones();
	}
}
