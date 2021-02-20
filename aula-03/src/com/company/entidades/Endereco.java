package com.company.entidades;

public class Endereco {

	private String rua;
	private String numeroDaCasa;
	private String bairro;
	private String cidade;

	public Endereco(String rua, String numeroDaCasa, String bairro, String cidade) {
		this.rua = rua;
		this.numeroDaCasa = numeroDaCasa;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

}
