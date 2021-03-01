package br.com.cwi.resetflix.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarDiretorRequest {

	private String nome;
	private List<Long> idFilmes;

	public CriarDiretorRequest(String nome, List<Long> idFilmes) {
		this.nome = nome;
		this.idFilmes = idFilmes;
	}

}
