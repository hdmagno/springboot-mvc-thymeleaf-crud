package com.javaguide.service;

import java.util.List;

import com.javaguide.entity.Aluno;

public interface AlunoService {
	
	List<Aluno> buscarTodos();
	
	void gravarAluno(Aluno aluno);
	
	Aluno buscarPorId(long id);
	
	void deletarAluno(long id);

}
