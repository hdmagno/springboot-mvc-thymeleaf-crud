package com.javaguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaguide.entity.Aluno;
import com.javaguide.service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping("/")
	public String listarAlunos(Model model) {
		model.addAttribute("listaDeAlunos", alunoService.buscarTodos());
		return "index";
	}

	@GetMapping("/novoAluno")
	public String gravarAluno(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "novo_aluno";
	}

	@PostMapping("/gravarAluno")
	public String gravarAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.gravarAluno(aluno);
		return "redirect:/";
	}

	@GetMapping("/editarAluno/{id}")
	public String editarAluno(@PathVariable("id") long id, Model model) {
		Aluno aluno = alunoService.buscarPorId(id);
		model.addAttribute("aluno", aluno);
		return "atualizar_aluno";
	}

	@GetMapping("/deletarAluno/{id}")
	public String deletarAluno(@PathVariable("id") long id) {
		this.alunoService.deletarAluno(id);
		return "redirect:/";

	}

}
