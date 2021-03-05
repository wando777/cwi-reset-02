package br.com.cwi.resetflix.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtorEntity {

	private Long id;
	private String nome;
	private List<Long> idsFilmes;
	private List<Long> idsSeries;

	public AtorEntity(final String nome, final List<Long> idsFilmes, final List<Long> idsSeries) {
		this.nome = nome;
		this.idsFilmes = idsFilmes;
		this.idsSeries = idsSeries;
	}

	public AtorEntity(final Long id, final String nome, final List<Long> idsFilmes) {
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
		AtorEntity other = (AtorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
