package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

	static List<AtorEntity> atores = new ArrayList<>();
	static Long contadorIds = 1l;

	public List<AtorEntity> getAtores() {
		return atores;
	}

	public Long criarAtor(final AtorEntity atorSalvar) {
		if (atorSalvar.getId() == null) {
			atorSalvar.setId(contadorIds);
			contadorIds++;
		}

		atores.add(atorSalvar);

		return atorSalvar.getId();
	}

	public AtorEntity acharAtorPorId(final Long id) {
		for (AtorEntity atorEntity : atores) {
			if (atorEntity.getId().equals(id)) {
				return atorEntity;
			}
		}
		return null;
	}

	public List<AtorEntity> listaDeAtoresPorFilme(final Long id) {
		List<AtorEntity> filmesAtor = new ArrayList<AtorEntity>();
		for (AtorEntity ator : atores) {
			for (Long idFilme : ator.getIdsFilmes()) {
				if (idFilme.equals(id)) {
					filmesAtor.add(ator);
				}
			}
		}
		return filmesAtor;
	}
	
	public List<AtorEntity> listaDeAtoresPorSerie(final Long id) {
		//TODO encontrar atores por id da série
		return null;
	}
	
}
