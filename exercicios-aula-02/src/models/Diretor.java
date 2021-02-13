package models;

import models.enums.Genero;

public class Diretor {

	private String nome;
	private Integer idade;
	private Integer numeroDeFilmesDirigidos;
	private Genero genero;

	public Diretor(String nome, Integer idade, Integer numeroDeFilmesDirigidos, Genero genero) {
		this.nome = nome;
		this.idade = idade;
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
		this.genero = genero;
	}

	public Diretor() {
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

	public Integer getNumeroDeFilmesDirigidos() {
		return numeroDeFilmesDirigidos;
	}

	public void setNumeroDeFilmesDirigidos(Integer numeroDeFilmesDirigidos) {
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
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
