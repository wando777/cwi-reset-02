package br.com.minha_casa_minha_desgraca.models;

public class Apartamento extends Imovel {

	private String andar;

	public Apartamento(Double valor, Endereco endereco, String andar) {
		super(valor, endereco);
		this.andar = andar;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	@Override
	public String apresentacao() {
		return "Apartamento no " + getAndar() + " andar, localizado no endereço: " + getEndereco().toString()
				+ " no valor de R$" + getValor();
	}

}
