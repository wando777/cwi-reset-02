package br.com.banco.desgraca.domain.enums;

public enum TipoTransacao {

	SAQUE("Saque"), DEPOSITO("Deposito"), TRANSFERENCIA("Transferência");

	private String descricao;

	TipoTransacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
