package br.com.cwi.resetflix.mapper;

import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;

public class ConsultarDetalhesSerieResponseMapper {

	public ConsultarDetalhesSerieResponse mapear(final SerieEntity serieSalva, final List<AtorEntity> atores) {
		List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
		return new ConsultarDetalhesSerieResponse(serieSalva.getId(), serieSalva.getNome(), serieSalva.getGenero(),
				serieSalva.getTemporadas(), serieSalva.getEpisodios(), atoresResponse);
	}

}
