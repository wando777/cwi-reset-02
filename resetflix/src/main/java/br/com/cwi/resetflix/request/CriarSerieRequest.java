package br.com.cwi.resetflix.request;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CriarSerieRequest {

	private String nome;
	private Integer temporadas;
	private Integer episodios;
	private List<Long> idsAtores;
	private Genero genero;

	public CriarSerieRequest(final String nome, final Integer temporadas, final Integer episodios,
			final List<Long> idsAtores, final Genero genero) {
		this.nome = nome;
		this.temporadas = temporadas;
		this.episodios = episodios;
		this.idsAtores = idsAtores;
		this.genero = genero;
	}

}
