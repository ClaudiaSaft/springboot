package br.com.matera.springboot.service;

import org.springframework.stereotype.Service;

import br.com.matera.springboot.entity.Client;

@Service
public class ClientService {

	public void upperName(Client client) {
		client.setName(client.getName().toUpperCase());
	}

}
