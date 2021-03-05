package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSerieResponseMapper;
import br.com.cwi.resetflix.mapper.SeriesEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;

@Service
public class SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	@Autowired
	private AtoresRepository atorRepository;
	
	static SeriesEntityMapper MAPPER_ENTITY = new SeriesEntityMapper();
	static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
	static ConsultarDetalhesSerieResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesSerieResponseMapper();
	
	public List<SerieResponse> getSeries(Genero genero) {
		final List<SerieEntity> series = seriesRepository.getPorGenero(genero);
		return MAPPER_RESPONSE.mapear(series);
	}
	
	public Long criarSerie(final CriarSerieRequest request) {
		SerieEntity serieSalvar = MAPPER_ENTITY.mapear(request);
		return seriesRepository.criarSerie(serieSalvar);
	}

	public ConsultarDetalhesSerieResponse getSeriesDetalhes(Long id) {
		SerieEntity serieSalva = seriesRepository.acharSeriePorId(id);
		List<AtorEntity> atores = atorRepository.listaDeAtoresPorSerie(id);
		return MAPPER_DETALHES_FILME.mapear(serieSalva, atores);
	}
	
	

}
