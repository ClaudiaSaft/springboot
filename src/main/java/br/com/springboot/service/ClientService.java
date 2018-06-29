package br.com.springboot.service;

import java.util.List;

import br.com.springboot.entity.data.ClientData;

public interface ClientService {

	List<ClientData> findAll();

	Long save(ClientData client);

	ClientData findOne(Long id);

}
