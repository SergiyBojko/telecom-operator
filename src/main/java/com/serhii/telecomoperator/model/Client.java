package com.serhii.telecomoperator.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.serhii.telecomoperator.dto.ClientDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String fullName;
	private LocalDate birthday;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ElementCollection
	@CollectionTable(name="phone", joinColumns=@JoinColumn(name="client_id"))
	@Column(name="phone")
	private List<String> phones;
	
	public Client (long id) {
		this.id = id;
	}
	
	public Client (ClientDTO client) {
		id = client.getId();
		fullName = client.getFullName();
		birthday = client.getBirthday();
		gender = Gender.valueOf(client.getGender());
		phones = client.getPhones();
	}
	
	public enum Gender {
		MALE, FEMALE
	}

}
