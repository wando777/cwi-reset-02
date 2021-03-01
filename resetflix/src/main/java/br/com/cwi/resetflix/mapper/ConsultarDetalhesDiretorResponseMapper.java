package br.com.cwi.resetflix.mapper;

import java.util.List;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

public class ConsultarDetalhesDiretorResponseMapper {

	public ConsultarDetalhesDiretorResponse mapear(final DiretorEntity diretorSalvo,
			final List<FilmeEntity> filmesDiretor) {
		List<FilmeResponse> filmesResponse = new FilmeResponseMapper().mapear(filmesDiretor);
		return new ConsultarDetalhesDiretorResponse(diretorSalvo.getId(), diretorSalvo.getNome(), filmesResponse);
	}

}