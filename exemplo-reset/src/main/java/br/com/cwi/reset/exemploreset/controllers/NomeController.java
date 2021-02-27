package br.com.cwi.reset.exemploreset.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NomeController {

	private static String nome = "Wando";

	@GetMapping("/nome")
	public String getNome() {
		return nome;
	}

	@PutMapping("/nome/{novoNome}")
	public String novaMensagem(@PathVariable String novoNome) {
		NomeController.nome = novoNome;
		return nome;
	}

	@DeleteMapping("/nome")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover() {
		NomeController.nome = null;
	}
	
}
