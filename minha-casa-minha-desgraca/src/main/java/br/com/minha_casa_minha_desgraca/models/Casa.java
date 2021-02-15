package br.com.minha_casa_minha_desgraca.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Casa extends Imovel {

	private boolean patio;

	public Casa(Double valor, Endereco endereco, boolean patio) {
		super(valor, endereco);
		this.patio = patio;
	}

	@Override
	public String apresentacao() {
		String temPatio = isPatio() ? " com pátio" : " sem pátio";
		return "Casa localizada no endereço: " + getEndereco().toString() + " no valor de R$" + getValor() + temPatio;
	}

}
