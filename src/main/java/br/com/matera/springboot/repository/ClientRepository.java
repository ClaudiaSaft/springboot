package br.com.matera.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matera.springboot.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
