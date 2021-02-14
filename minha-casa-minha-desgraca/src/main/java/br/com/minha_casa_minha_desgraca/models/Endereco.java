package br.com.minha_casa_minha_desgraca.models;

import br.com.minha_casa_minha_desgraca.models.enums.UnidadeFederativa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Endereco {

	private String rua;
	private String numeroDaCasa;
	private String bairro;
	private String cidade;
	private UnidadeFederativa estado;

	public Endereco(String rua, String numeroDaCasa, String bairro, String cidade, UnidadeFederativa estado) {
		this.rua = rua;
		this.numeroDaCasa = numeroDaCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "rua " + rua + ", número " + numeroDaCasa + ", bairro " + bairro + ", cidade " + cidade + " - " + estado;
	}

}
