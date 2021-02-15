package br.com.minha_casa_minha_desgraca.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class Imovel {

	private Double valor;
	private Endereco endereco;

	public Imovel(Double valor, Endereco endereco) {
		this.valor = valor;
		this.endereco = endereco;
	}

	public String apresentacao() {
		return "Imóvel localizado no endereço: " + endereco.toString() + " no valor de R$" + valor;
	}

}
