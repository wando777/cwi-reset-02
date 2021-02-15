package br.com.minha_casa_minha_desgraca.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Apartamento extends Imovel {

	private String andar;

	public Apartamento(Double valor, Endereco endereco, String andar) {
		super(valor, endereco);
		this.andar = andar;
	}

	@Override
	public String apresentacao() {
		return "Apartamento no " + getAndar() + " andar, localizado no endereço: " + getEndereco().toString()
				+ " no valor de R$" + getValor();
	}

}
