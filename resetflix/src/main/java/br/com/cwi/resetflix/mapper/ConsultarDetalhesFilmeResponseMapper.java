package br.com.cwi.resetflix.mapper;

import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

public class ConsultarDetalhesFilmeResponseMapper {

	public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filmeSalvo, final DiretorEntity diretor,
			final List<AtorEntity> atores) {
		DiretoresResponse diretorResponse = new DiretoresResponse(diretor.getId(), diretor.getNome());
		List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
		return new ConsultarDetalhesFilmeResponse(filmeSalvo.getId(), filmeSalvo.getNome(), filmeSalvo.getGenero(),
				diretorResponse, atoresResponse);
	}

}
