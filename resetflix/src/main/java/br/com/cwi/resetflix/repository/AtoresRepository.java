package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

	@Autowired
	private FilmeRepository filmeRepository;

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
				if (idFilme.equals(id) && filmeRepository.acharFilmePorId(id).getIdsAtores().contains(ator.getId())) {
					filmesAtor.add(ator);
				}
			}
		}
		return filmesAtor;
	}

	public List<AtorEntity> listaDeAtoresPorSerie(final Long id) {
		return atores.stream().filter(ator -> ator.getIdsSeries().contains(id)).collect(Collectors.toList());
	}

}
