package br.com.banco.desgraca.domain.enums;

public enum TipoConta {

	CORRENTE("Corrente"), POUPANCA("Poupança"), DIGITAL("Digital");

	private String descricao;

	TipoConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
