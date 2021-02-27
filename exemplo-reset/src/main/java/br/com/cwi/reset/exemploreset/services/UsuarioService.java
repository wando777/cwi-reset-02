package br.com.cwi.reset.exemploreset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.reset.exemploreset.domains.Usuario;
import br.com.cwi.reset.exemploreset.exceptions.BadRequestException;
import br.com.cwi.reset.exemploreset.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.getUsuarios();
	}

	public Usuario criarUsuario(Usuario usuario) {
		if (usuario == null) {
			throw new BadRequestException();
		}
		return usuarioRepository.addUsuario(usuario);
	}

	public void deletarUsuario(Integer id) {
		usuarioRepository.deletarUsuario(id);
	}

}
