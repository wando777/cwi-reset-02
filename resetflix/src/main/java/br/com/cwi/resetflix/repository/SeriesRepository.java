package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
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
	
	public List<SerieEntity> getPorGenero(Genero genero) {
        if (genero == null) {
            return getSeries();
        } else {
            return series.stream()
            		.filter(serie -> serie.getGenero().equals(genero))
            		.collect(Collectors.toList());
        }
    }

}
