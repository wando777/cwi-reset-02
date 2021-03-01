package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

//    static List<FilmeEntity> filmes = Collections.singletonList(
//        new FilmeEntity(1l,"Interestelar", Genero.FICCAO_CIENTIFICA,
//            1l, asList(1l))
//    );
	private static List<FilmeEntity> filmes = new ArrayList<FilmeEntity>();
	static Long contadorIds = 1l;

	public List<FilmeEntity> getFilmes() {
		return filmes;
	}

	public Long criarFilme(final FilmeEntity filmeSalvar) {
		if (filmeSalvar.getId() == null) {
			filmeSalvar.setId(contadorIds++);
		}
		filmes.add(filmeSalvar);
		return filmeSalvar.getId();
	}

	public List<FilmeEntity> acharFilmesAtor(final Long id) {
		List<FilmeEntity> filmesAtores = new ArrayList<FilmeEntity>();
		for (FilmeEntity filmeEntity : filmes) {
			for (Long idAtor : filmeEntity.getIdsAtores()) {
				if (idAtor.equals(id)) {
					filmesAtores.add(filmeEntity);
				}
			}
		}
		return filmesAtores;
	}

	public List<FilmeEntity> acharFilmesDiretor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
