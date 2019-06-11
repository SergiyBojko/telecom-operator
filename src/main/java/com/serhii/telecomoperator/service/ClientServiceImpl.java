package com.serhii.telecomoperator.service;

import org.springframework.stereotype.Service;

import com.serhii.telecomoperator.dto.ClientDTO;
import com.serhii.telecomoperator.model.Client;
import com.serhii.telecomoperator.repository.ClientRepo;
import com.serhii.telecomoperator.service.base.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
	
	ClientRepo clientRepo;

	@Override
	public ClientDTO save(ClientDTO client) {
		Client saved = clientRepo.save(new Client(client));
		return new ClientDTO(saved);
	}

}
