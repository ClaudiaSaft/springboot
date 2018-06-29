package br.com.springboot.entity.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.springboot.entity.enumeration.GenderEnum;

public class ClientData {

	private Long id;
	@NotNull(message="Campo nome é obrigatório")
	@Size(min=3, message="O campo nome deve ter mais do que 3 caracteres")
	private String name;
	private Integer age;
	private GenderEnum gender;

	public ClientData() {
	}
	
	public ClientData(Long id, String name, Integer age, GenderEnum gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

}