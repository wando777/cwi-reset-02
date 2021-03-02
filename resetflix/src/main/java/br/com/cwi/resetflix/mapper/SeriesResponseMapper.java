package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.SerieResponse;

public class SeriesResponseMapper {

	public List<SerieResponse> mapear(final List<SerieEntity> series) {
		List<SerieResponse> seriesResponse = new ArrayList<>();
		for (SerieEntity serie : series) {
			seriesResponse.add(new SerieResponse(serie.getId(), serie.getNome(), serie.getGenero()));
		}
		return seriesResponse;
	}

}
