package br.com.cwi.resetflix.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarAtorRequest {

	private String nome;
	private List<Long> idFilmes;
	private List<Long> idSeries;

	public CriarAtorRequest(final String nome, final List<Long> idFilmes, final List<Long> idSeries) {
		this.nome = nome;
		this.idFilmes = idFilmes;
		this.idSeries = idSeries;
	}

}
