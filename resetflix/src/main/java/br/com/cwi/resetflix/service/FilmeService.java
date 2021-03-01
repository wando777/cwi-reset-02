package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private DiretorRepository diretorRepository;

	@Autowired
	private AtoresRepository atorRepository;

	static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
	static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
	static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();

	public List<FilmeResponse> getFilmes() {
		final List<FilmeEntity> filmes = filmeRepository.getFilmes();
		return MAPPER_RESPONSE.mapear(filmes);
	}

	public Long criarFilme(final CriarFilmeRequest request) {
		FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
		return filmeRepository.criarFilme(filmeSalvar);
	}

	public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(Long id) {
		FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(id);
		DiretorEntity diretor = diretorRepository.acharDiretorPorId(filmeSalvo.getIdDiretor());
		List<AtorEntity> atores = atorRepository.listaDeFilmesPorAtor(id);
		return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretor, atores);
	}

}
