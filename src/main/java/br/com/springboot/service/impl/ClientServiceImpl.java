package br.com.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.entity.Client;
import br.com.springboot.entity.data.ClientData;
import br.com.springboot.repository.ClientRepository;
import br.com.springboot.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<ClientData> findAll() {
		Iterable<Client> clients = clientRepository.findAll();
		
		List<ClientData> clientsData = new ArrayList<>();
		clients.forEach(c -> clientsData.add(parseClientToClientData(c)));
		
		return clientsData;
	}

	@Override
	public Long save(ClientData clientData) {
		Client client = parseClientDataToClient(clientData);
		Client clientSaved = clientRepository.save(client);
		return clientSaved.getId();
	}

	@Override
	public ClientData findOne(Long id) {
		Client client = clientRepository.findOne(id);
		ClientData clientData = parseClientToClientData(client);
		return clientData;
	}

	private ClientData parseClientToClientData(Client client) {
		return new ClientData(client.getId(), client.getName(), client.getAge(), client.getGender());
	}

	private Client parseClientDataToClient(ClientData clientData) {
		return new Client(clientData.getId(), clientData.getName(), clientData.getAge(), clientData.getGender());
	}
}
