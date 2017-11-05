package br.com.matera.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.matera.springboot.entity.Client;
import br.com.matera.springboot.repository.ClientRepository;

@RestController
public class ClientRest {

	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(name="/client", method=RequestMethod.GET)
	public List<Client> getClient() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@RequestMapping(name="/client", method=RequestMethod.POST)
	public Long newClient(@RequestBody Client client) {
		System.out.println(client);
		Client newClient = clientRepository.save(client);
		return newClient.getId();
	}
	
	@RequestMapping("/client/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		return clientRepository.findOne(id);
	}
	
}