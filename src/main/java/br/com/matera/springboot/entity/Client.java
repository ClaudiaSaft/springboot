package br.com.matera.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CLIENT")
public class Client {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME")
	@NotEmpty(message="Campo nome é obrigatório")
	@Length(min=3, message="O campo nome deve ter mais do que 3 caracteres")
	private String name;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="GENDER")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;

	public Client(Long id, String name, Integer age, GenderEnum gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Client() {
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

	public enum GenderEnum{
		FEMININO, MASCULINO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}