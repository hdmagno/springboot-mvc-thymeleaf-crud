package com.javaguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguide.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
