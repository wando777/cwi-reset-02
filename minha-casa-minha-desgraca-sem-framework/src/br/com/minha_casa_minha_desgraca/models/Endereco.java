package br.com.minha_casa_minha_desgraca.models;

import br.com.minha_casa_minha_desgraca.models.enums.UnidadeFederativa;

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

	public Endereco() {
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UnidadeFederativa getEstado() {
		return estado;
	}

	public void setEstado(UnidadeFederativa estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "rua " + rua + ", número " + numeroDaCasa + ", bairro " + bairro + ", cidade " + cidade + " - " + estado;
	}

}
