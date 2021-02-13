package models;

import models.enums.Genero;

public class Ator extends Pessoa {

	private Integer numeroDeOscars;

	public Ator(String nome, Integer idade, Genero genero, Integer numeroDeOscars) {
		super(nome, idade, genero);
		this.numeroDeOscars = numeroDeOscars;
	}

	public Integer getNumeroDeOscars() {
		return numeroDeOscars;
	}

	public void setNumeroDeOscars(Integer numeroDeOscars) {
		this.numeroDeOscars = numeroDeOscars;
	}

}
