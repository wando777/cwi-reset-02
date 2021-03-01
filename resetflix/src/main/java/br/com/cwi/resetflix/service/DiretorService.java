package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesDiretorResponseMapper;
import br.com.cwi.resetflix.mapper.DiretorEntityMapper;
import br.com.cwi.resetflix.mapper.DiretorResponseMapper;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

@Service
public class DiretorService {

	@Autowired
	private DiretorRepository diretorRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	private static DiretorEntityMapper MAPPER_ENTITY = new DiretorEntityMapper();
	private static DiretorResponseMapper MAPPER_RESPONSE = new DiretorResponseMapper();
	private static ConsultarDetalhesDiretorResponseMapper MAPPER_DETALHES_DIRETOR = new ConsultarDetalhesDiretorResponseMapper();

	public List<DiretoresResponse> getDiretores() {
		final List<DiretorEntity> diretores = diretorRepository.getDiretores();
		return MAPPER_RESPONSE.mapear(diretores);
	}

	public Long criarDiretor(final CriarDiretorRequest request) {
		DiretorEntity diretorSalvar = MAPPER_ENTITY.mapear(request);
		return diretorRepository.criarDiretor(diretorSalvar);
	}

	public ConsultarDetalhesDiretorResponse consultarDetalhesDiretor(Long id) {
		DiretorEntity diretorSalvo = diretorRepository.acharDiretorPorId(id);
		List<FilmeEntity> filmesDiretor = filmeRepository.acharFilmesDiretor(id);
		return MAPPER_DETALHES_DIRETOR.mapear(diretorSalvo, filmesDiretor);
	}

}
