package br.com.cwi.resetflix.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.UserEntity;

@Repository
public class UserRepository {

	public static UserEntity usuario = new UserEntity();

	public void assistirFilme(FilmeEntity filme) {
		usuario.adicionarFilme(filme);
	}

	public List<FilmeEntity> filmesAssistidos() {
		return usuario.getIdFilmeAssistido();
	}

	public Genero getGeneroRecomendado() {
		Map<Genero, Integer> generos = new HashMap<Genero, Integer>();
		for (FilmeEntity filme : usuario.getIdFilmeAssistido()) {
			if (!generos.containsKey(filme.getGenero())) {
				generos.put(filme.getGenero(), 1);
			} else {
				generos.put(filme.getGenero(), 1 + generos.get(filme.getGenero()));
			}
		}
		// Encontrar o genero mais visto
//		final Map<Genero, Integer> generosOrdenados = generos.entrySet()
//				.stream()
//				.sorted(Map.Entry.comparingByValue())
//		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		Integer max = 0;
		Genero gMax = null;
		Set<Genero> chaves = generos.keySet();
		for (Iterator<Genero> it = chaves.iterator(); it.hasNext();) {
			Genero chave = it.next();
			if (generos.get(chave) > max) {
				max = generos.get(chave);
				gMax = chave;
			}
		}

		return gMax;
	}

}
