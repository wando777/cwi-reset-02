package br.com.minha_casa_minha_desgraca.models;

public abstract class Imovel {

	private Double valor;
	private Endereco endereco;

	public Imovel(Double valor, Endereco endereco) {
		this.valor = valor;
		this.endereco = endereco;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String apresentacao() {
		return "Imóvel localizado no endereço: " + endereco.toString() + " no valor de R$" + valor;
	}

}
