package br.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springboot.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
