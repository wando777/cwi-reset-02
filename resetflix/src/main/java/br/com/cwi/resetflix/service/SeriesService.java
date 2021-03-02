package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.SeriesEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.SerieResponse;

@Service
public class SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	@Autowired
	private AtoresRepository atorRepository;
	
	static SeriesEntityMapper MAPPER_ENTITY = new SeriesEntityMapper();
	static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();

	public List<SerieResponse> getSeries() {
		final List<SerieEntity> series = seriesRepository.getSeries();
		return MAPPER_RESPONSE.mapear(series);
	}
	
	public Long criarSerie(final CriarSerieRequest request) {
		SerieEntity serieSalvar = MAPPER_ENTITY.mapear(request);
		return seriesRepository.criarSerie(serieSalvar);
	}

}
