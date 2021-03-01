package br.com.cwi.resetflix.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarDetalhesDiretorResponse {

	private Long id;
	private String nome;
	private List<FilmeResponse> filmes;

	public ConsultarDetalhesDiretorResponse(Long id, String nome, List<FilmeResponse> filmes) {
		this.id = id;
		this.nome = nome;
		this.filmes = filmes;
	}

	public ConsultarDetalhesDiretorResponse(String nome, List<FilmeResponse> filmes) {
		this.nome = nome;
		this.filmes = filmes;
	}

}
