package br.com.minha_casa_minha_desgraca.models;

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
	private String estado;

	public Endereco(String rua, String numeroDaCasa, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numeroDaCasa = numeroDaCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

}
