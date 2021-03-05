package br.com.cwi.resetflix.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

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

}
