package com.serhii.telecomoperator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serhii.telecomoperator.dto.ClientDTO;
import com.serhii.telecomoperator.service.base.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/client")
public class ClientController {

	private ClientService clientService;
	
	@PostMapping
	ClientDTO save(@RequestBody ClientDTO client) {
		return clientService.save(client);
	}
}
