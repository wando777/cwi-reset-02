package br.com.cwi.reset.exemploreset.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.reset.exemploreset.domains.Usuario;

@Repository
public class UsuarioRepository {

	private static List<Usuario> usuarios = new ArrayList<>();

	private static Integer id = 1;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuarioById(Integer id) {
		Usuario deletar = null;
		for (Usuario u : usuarios) {
			if (u.getId() == id) {
				deletar = u;
			}
		}
		return deletar;
	}

	public Usuario addUsuario(Usuario usuario) {
		usuario.setId(id++);
		usuarios.add(usuario);
		return usuario;
	}

	public void deletarUsuario(Integer id) {
		usuarios.remove(getUsuarioById(id));
	}

}
