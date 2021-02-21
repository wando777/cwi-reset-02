package com.company.entidades;

import com.company.exceptions.editoraInvalidaException;

public class Editora {

	private String nome;

	private Endereco endereco;

	public Editora(String nome, Endereco endereco) {

		if (nome.equals("DC Comics")) {
			throw new editoraInvalidaException("A editora em questão não pode ser instanciada.");
		}

		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Editora [nome=" + nome + ", endereco=" + endereco.toString() + "]";
	}

}
