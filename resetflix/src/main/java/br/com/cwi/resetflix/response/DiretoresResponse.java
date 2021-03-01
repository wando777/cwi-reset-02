package br.com.cwi.resetflix.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiretoresResponse {

	Long id;
	String nome;

	public DiretoresResponse(final Long id, final String nome) {
		this.id = id;
		this.nome = nome;
	}
}
