package br.com.springboot.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.entity.data.ClientData;
import br.com.springboot.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientRest {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<ClientData>> getAllClients() {
		List<ClientData> clients = clientService.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Long> saveClient(@Valid @RequestBody ClientData client) {
		Long newClientId = clientService.save(client);
		return ResponseEntity.ok().body(newClientId);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClientData> getClientById(@PathVariable("id") Long id) {
		ClientData client = clientService.findOne(id);
		return ResponseEntity.ok().body(client);
	}
	
	@RequestMapping(value="/name/by", params = {"id"}, method=RequestMethod.GET)
	public ResponseEntity<String> getClientNameByParameters(@RequestParam Long id) {
		ClientData clientById = clientService.findOne(id);
		return ResponseEntity.ok().body(clientById.getName());
	}
}