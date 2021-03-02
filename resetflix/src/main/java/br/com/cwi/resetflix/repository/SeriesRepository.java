package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.SerieEntity;

@Repository
public class SeriesRepository {

	private static List<SerieEntity> series = new ArrayList<SerieEntity>();
	static Long contadorIds = 1l;

	public List<SerieEntity> getSeries() {
		return series;
	}

	public Long criarSerie(final SerieEntity serieSalvar) {
		if (serieSalvar.getId() == null) {
			serieSalvar.setId(contadorIds++);
		}
		series.add(serieSalvar);
		return serieSalvar.getId();
	}

	public SerieEntity acharSeriePorId(Long id) {
		for (SerieEntity serieEntity : series) {
			if (serieEntity.getId().equals(id)) {
				return serieEntity;
			}
		}
		return null;
	}

}
