package br.com.cwi.resetflix.response;

import br.com.cwi.resetflix.domain.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SerieResponse {

	private Long id;
	private String nome;
	private Genero genero;

	public SerieResponse(final Long id, final String nome, final Genero genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}

}