package models;

import models.enums.Genero;

public class Diretor extends Pessoa {

	private Integer numeroDeFilmesDirigidos;

	public Diretor(String nome, Integer idade, Integer numeroDeFilmesDirigidos, Genero genero) {
		super(nome, idade, genero);
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
	}

	public Integer getNumeroDeFilmesDirigidos() {
		return numeroDeFilmesDirigidos;
	}

	public void setNumeroDeFilmesDirigidos(Integer numeroDeFilmesDirigidos) {
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
	}

	@Override
	public String toString() {
		return "Diretor: " + getNome() + "\n" + "Diirigiu " + getNumeroDeFilmesDirigidos() + " filmes";
	}
	
}
