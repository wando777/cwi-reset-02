package models;

import models.enums.Genero;

public class Pessoa {

	private String nome;
	private Integer idade;
	private Genero genero;

	public Pessoa(String nome, Integer idade, Genero genero) {
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + "Idade:" + idade + "\n" + "Genero: " + genero.getDescricao();
	}
}
