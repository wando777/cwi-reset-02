package models;

import java.time.LocalDate;
import java.time.Period;

import models.enums.Genero;

public class Pessoa {

	private String nome;
	private LocalDate dtNascimento;
	private Genero genero;

	public Pessoa(String nome, LocalDate dtNascimento, Genero genero) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	private Integer calcularIdade() {
		return Period.between(dtNascimento, LocalDate.now()).getYears();
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + "Idade:" + calcularIdade() + "\n" + "Genero: " + genero.getDescricao();
	}
}
