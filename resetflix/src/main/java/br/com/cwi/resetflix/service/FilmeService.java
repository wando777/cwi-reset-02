package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.repository.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

	static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
	static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();
	static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();
	// static UserEntityMapper MAPPER_USER = new UserEntityMapper();

	public List<FilmeResponse> getFilmes(Genero genero) {
		final List<FilmeEntity> filmes = filmeRepository.getPorGenero(genero);
//		List<FilmeEntity> filmesComGenero = new ArrayList<FilmeEntity>();
//		
//		if (genero != null) {
//			for (FilmeEntity filme : filmes) {
//				if (filme.getGenero().equals(genero)) {
//					filmesComGenero.add(filme);
//				}
//			}
//			return MAPPER_RESPONSE.mapear(filmesComGenero);
//		}
		return MAPPER_RESPONSE.mapear(filmes);
	}

	public Long criarFilme(final CriarFilmeRequest request) {
		FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);
		return filmeRepository.criarFilme(filmeSalvar);
	}

	public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(Long id) {
		FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(id);
		DiretorEntity diretor = diretorRepository.acharDiretorPorId(filmeSalvo.getIdDiretor());
		List<AtorEntity> atores = atorRepository.listaDeAtoresPorFilme(id);
		return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretor, atores);
	}

	public void assistirFilme(final Long id) {
		FilmeEntity filmeSalvo = filmeRepository.acharFilmePorId(id);
		userRepository.assistirFilme(filmeSalvo);
	}

	public Genero generoRecomendado() {
		//TODO O retorno final deve ser um filme, assim:
		//Pegar o genero recomendado e iterar na lista de filmes;
		return userRepository.getGeneroRecomendado();
	}

}
