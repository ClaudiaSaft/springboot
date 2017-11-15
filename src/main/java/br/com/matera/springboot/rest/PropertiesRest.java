package br.com.matera.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesRest {

	@Value("${paginacao.qtd_por_pagina}")
	private Integer qtdPorPagina;
	
	@RequestMapping(value="/page/count", method=RequestMethod.GET)
	public Integer getCountPages() {
		return qtdPorPagina;
	}
}
