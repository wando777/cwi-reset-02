package br.com.cwi.resetflix.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserEntity {

	private Long id;
	private String nome;
	//private List<Long> idFilmeAssistido = new ArrayList<Long>();
	private List<FilmeEntity> idFilmeAssistido = new ArrayList<FilmeEntity>();
	private List<SerieEntity> idSerieAssistida = new ArrayList<SerieEntity>();

	public UserEntity(Long id, String nome, List<FilmeEntity> idFilmeAssistido) {
		this.id = id;
		this.nome = nome;
		this.idFilmeAssistido = idFilmeAssistido;
	}
	
//	public void adicionarFilme(Long id) {
//		idFilmeAssistido.add(id);
//	}
	
	public void adicionarFilme(FilmeEntity filme) {
		idFilmeAssistido.add(filme);
	}
	
	public void adicionarSerie(SerieEntity serie) {
		idSerieAssistida.add(serie);
	}

}
