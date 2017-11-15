package br.com.matera.springboot.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matera.springboot.entity.Client;
import br.com.matera.springboot.repository.ClientRepository;
import br.com.matera.springboot.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientRest {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Client> getClient() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Object> newClient(@Valid @RequestBody Client client, BindingResult result) {
		if (result.hasErrors()) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.getAllErrors());
		}
		
		Client newClient = clientRepository.save(client);
		return ResponseEntity.ok().body(newClient.getId());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Client getClientById(@PathVariable("id") Long id) {
		Client client = clientRepository.findOne(id);
		clientService.upperName(client);
		return client;
	}
	
	@RequestMapping(value="/by", params = {"id"}, method=RequestMethod.GET)
	public String getClientByParameterId(@RequestParam Long id) {
		return clientRepository.findOne(id).getName();
	}
}