package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.DiretorEntity;

@Repository
public class DiretorRepository {

	private static List<DiretorEntity> diretores = new ArrayList<>();
	private static Long contadorIds = 1l;

	public List<DiretorEntity> getDiretores() {
		return diretores;
	}

	public Long criarDiretor(final DiretorEntity diretorSalvar) {
		if (diretorSalvar.getId() == null) {
			diretorSalvar.setId(contadorIds);
			contadorIds++;
		}
		diretores.add(diretorSalvar);

		return diretorSalvar.getId();
	}

	public DiretorEntity acharDiretorPorId(final Long id) {
		for (DiretorEntity diretorEntity : diretores) {
			if (diretorEntity.getId().equals(id)) {
				return diretorEntity;
			}
		}
		return null;
	}

}
