package models;

import java.time.LocalDate;

import models.enums.Genero;

public class Ator extends Pessoa {

	private Integer numeroDeOscars;

	public Ator(String nome, LocalDate idade, Genero genero, Integer numeroDeOscars) {
		super(nome, idade, genero);
		this.numeroDeOscars = numeroDeOscars;
	}

	public Integer getNumeroDeOscars() {
		return numeroDeOscars;
	}

	public void setNumeroDeOscars(Integer numeroDeOscars) {
		this.numeroDeOscars = numeroDeOscars;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Ganhou " + getNumeroDeOscars() + " Oscars";
	}

}
