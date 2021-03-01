package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.DiretoresResponse;

public class DiretorResponseMapper {

	public List<DiretoresResponse> mapear(final List<DiretorEntity> diretores) {
		List<DiretoresResponse> diretoresResponses = new ArrayList<>();

		for (DiretorEntity diretorEntity : diretores) {
			DiretoresResponse diretorResponse = new DiretoresResponse(diretorEntity.getId(), diretorEntity.getNome());
			diretoresResponses.add(diretorResponse);
		}
		return diretoresResponses;
	}

}
