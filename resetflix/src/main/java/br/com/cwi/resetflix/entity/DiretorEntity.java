package br.com.cwi.resetflix.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiretorEntity {

	private Long id;
	private String nome;
	private List<Long> idsFilmes;

	public DiretorEntity(String nome, List<Long> idsFilmes) {
		this.nome = nome;
		this.idsFilmes = idsFilmes;
	}

	public DiretorEntity(Long id, String nome, List<Long> idsFilmes) {
		this.id = id;
		this.nome = nome;
		this.idsFilmes = idsFilmes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiretorEntity other = (DiretorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
