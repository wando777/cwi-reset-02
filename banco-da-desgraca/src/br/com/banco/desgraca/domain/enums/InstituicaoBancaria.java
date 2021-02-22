package br.com.banco.desgraca.domain.enums;

public enum InstituicaoBancaria {

	BANCO_DO_BRASIL("Banco do Brasil"), BRADESCO("Bradesco"), CAIXA("Caixa"), ITAU("Itaú"), NUBANK("Nubank");

	private String descricao;

	InstituicaoBancaria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
