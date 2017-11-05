package br.com.matera.springboot.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matera.springboot.entity.Client;
import br.com.matera.springboot.entity.Client.GenderEnum;
import br.com.matera.springboot.repository.ClientRepository;

@RestController
public class ClientRest {

	@Autowired
	private ClientRepository clientRepository;
	
	private List<Client> clients;
	
	{
		clients = new ArrayList<>();
		clients.add(new Client(1L, "MARIA DA SILVA", 27, GenderEnum.FEMININO));
		clients.add(new Client(2L, "JOÃO DA SILVA SOUZA", 50, GenderEnum.MASCULINO));
		clients.add(new Client(3L, "PEDRO CARDOSO FERNANDES", 32, GenderEnum.MASCULINO));
		clients.add(new Client(4L, "TATIANE FERREIRA", 20, GenderEnum.FEMININO));
	}
	
	@RequestMapping("/client")
	public List<Client> getClient() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@RequestMapping("/client/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		Optional<Client> findFirst = clients.stream().filter(p -> p.getId() == id).findFirst();
		if (findFirst.isPresent()) {
			return findFirst.get();
		}
		return new Client();
	}
	
}