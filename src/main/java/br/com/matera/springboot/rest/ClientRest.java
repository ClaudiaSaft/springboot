package br.com.matera.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matera.springboot.entity.Client;
import br.com.matera.springboot.repository.ClientRepository;

@RestController
@RequestMapping(value="/client")
public class ClientRest {

	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Client> getClient() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Long newClient(@RequestBody Client client) {
		Client newClient = clientRepository.save(client);
		return newClient.getId();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
		return clientRepository.findOne(id);
	}
	
	@RequestMapping(value="/by", params = {"id"}, method=RequestMethod.GET)
	public String getClientByParameterId(@RequestParam Long id) {
		return clientRepository.findOne(id).getName();
	}
}