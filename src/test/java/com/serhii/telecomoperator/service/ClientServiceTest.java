package com.serhii.telecomoperator.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.serhii.telecomoperator.dto.ClientDTO;
import com.serhii.telecomoperator.model.Client;
import com.serhii.telecomoperator.model.Client.Gender;
import com.serhii.telecomoperator.repository.ClientRepo;
import com.serhii.telecomoperator.service.base.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {
	
	@MockBean
	private ClientRepo clientRepo;
	
	@Autowired
	private ClientService clientService;
	
	private ClientDTO clientDto;
	private Client client;
	
	@Before
	public void setup() {
		List<String> phones = Arrays.asList("1234");
		clientDto = new ClientDTO(1, "Ann", LocalDate.now(), Gender.FEMALE.toString(), phones);
		client = new Client(1, "Ann", LocalDate.now(), Gender.FEMALE, phones);
		Mockito.when(clientRepo.save(client)).thenReturn(client);
	}
	
	@Test
	public void serviceShouldCallSaveMethodOfRepository() {
		ClientDTO result = clientService.save(clientDto);
		
		assertEquals(result, clientDto);
		verify(clientRepo).save(client);
	}

}
