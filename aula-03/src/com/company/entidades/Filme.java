package com.company.entidades;

import com.company.heranças.Diretor;

public class Filme {

	private String nome;
	private String descricao;
	private Integer duracao;
	private Integer anoLancamento;
	private Integer avaliacao;
	private Diretor diretor;

	private static final int NOTA_MINIMA = 0;
	private static final int NOTA_MAXIMA = 5;

	public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Integer avaliacao,
			Diretor diretor) {
		defineAvaliacao(avaliacao);
		validaNomeEDefineAvaliacao(nome);

		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.diretor = diretor;
	}

	public void reproduzir() {
		System.out.println("Nome Filme: " + this.nome);
		System.out.println("Descrção: " + this.descricao);
		System.out.println("Duração: " + this.duracao);
		System.out.println("Nome do Diretor: " + this.diretor.getNome());
	}

	private void defineAvaliacao(Integer avaliacao) {
		if (avaliacao < NOTA_MINIMA || avaliacao > NOTA_MAXIMA) {
			throw new IllegalArgumentException(
					"A nota é inválida, ela deve estar entre " + NOTA_MINIMA + " e " + NOTA_MAXIMA);
		}
	}

	private void validaNomeEDefineAvaliacao(String nome) {
		if ("Batman vs Superman".equals(nome)) {
			this.avaliacao = 1;
		} else if ("Interestelar".equals(nome)) {
			this.avaliacao = 5;
		}
	}
}
