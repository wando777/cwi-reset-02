package br.com.cwi.resetflix.response;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ConsultarDetalhesSerieResponse {

	private Long id;
	private String nome;
	private Genero genero;
	private Integer temporadas;
	private Integer episodios;
	private List<AtoresResponse> atores;

	public ConsultarDetalhesSerieResponse(Long id, String nome, Genero genero, Integer temporadas, Integer episodios,
			List<AtoresResponse> atores) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.temporadas = temporadas;
		this.episodios = episodios;
		this.atores = atores;
	}

}
