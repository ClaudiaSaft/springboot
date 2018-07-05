package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
