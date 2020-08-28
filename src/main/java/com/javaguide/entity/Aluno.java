package com.javaguide.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = true)
	@NotBlank
	@Size(min = 2, message = "Nome deve conter no mínimo 2 e no máximo 50 caracteres")
	private String nome;
	@Column(nullable = true)
	@NotBlank
	@Size(min = 2, max = 50, message = "Sobrenome deve conter no mínimo 2 e no máximo 50 caracteres")
	private String sobrenome;
	@Column(nullable = true, unique = true)
	@NotBlank
	@Size(max = 50, message = "Máximo 50 caracteres")
	private String email;
	
	public Aluno() {
	}

	public Aluno(
			@NotBlank @Size(min = 2, message = "Nome deve conter no mínimo 2 e no máximo 50 caracteres") String nome,
			@NotBlank @Size(min = 2, max = 50, message = "Sobrenome deve conter no mínimo 2 e no máximo 50 caracteres") String sobrenome,
			@NotBlank @Size(max = 50, message = "Máximo 50 caracteres") String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [Id: " + id + ", Nome: " + nome + ", Sobrenome: " + sobrenome + ", Email: " + email + "]";
	}

}
