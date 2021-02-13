package models;

import models.enums.Genero;

public class Ator {

	private String nome;
	private Integer idade;
	private Integer numeroDeOscars;
	private Genero genero;

	public Ator(String nome, Integer idade, Integer numeroDeOscars, Genero genero) {
		this.nome = nome;
		this.idade = idade;
		this.numeroDeOscars = numeroDeOscars;
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

	public Integer getNumeroDeOscars() {
		return numeroDeOscars;
	}

	public void setNumeroDeOscars(Integer numeroDeOscars) {
		this.numeroDeOscars = numeroDeOscars;
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
