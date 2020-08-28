package com.javaguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaguide.entity.Aluno;
import com.javaguide.repository.AlunoRepository;

public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	AlunoRepository alunorepository;

	@Override
	public List<Aluno> buscarTodos() {
		return alunorepository.findAll();
	}

	@Override
	public void gravarAluno(Aluno aluno) {
		this.alunorepository.save(aluno);
		
	}

	@Override
	public Aluno buscarPorId(long id) {
		Optional<Aluno> optional = alunorepository.findById(id);
		Aluno aluno = null;
		if(optional.isPresent()) {
			aluno = optional.get();
		}else {
			throw new RuntimeException("Aluno não localizado para o id: " + id);
		}
		return aluno;
	}

	@Override
	public void deletarAluno(long id) {
		this.alunorepository.deleteById(id);
		
	}

}
