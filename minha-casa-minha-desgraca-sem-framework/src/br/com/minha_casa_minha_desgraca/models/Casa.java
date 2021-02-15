package br.com.minha_casa_minha_desgraca.models;

public class Casa extends Imovel {

	private boolean patio;

	public Casa(Double valor, Endereco endereco, boolean patio) {
		super(valor, endereco);
		this.patio = patio;
	}

	public boolean isPatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}

	@Override
	public String apresentacao() {
		String temPatio = isPatio() ? " com pátio" : " sem pátio";
		return "Casa localizada no endereço: " + getEndereco().toString() + " no valor de R$" + getValor() + temPatio;
	}

}
