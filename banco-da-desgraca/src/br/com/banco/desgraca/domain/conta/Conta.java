package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

public abstract class Conta implements ContaBancaria {

	private Integer numeroConta;

	private InstituicaoBancaria instituicaoBancaria;

	private Double saldo;

	private TipoConta tipo;

	// private ListaContas listaContas;

	public Conta() {
	}

	public Conta(InstituicaoBancaria instituicaoBancaria) {
		this.instituicaoBancaria = instituicaoBancaria;
		this.saldo = 0d;
		numeroConta = GeradorConta.getProximaConta();
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public InstituicaoBancaria getInstituicaoBancaria() {
		return instituicaoBancaria;
	}

	public void setInstituicaoBancaria(InstituicaoBancaria instituicaoBancaria) {
		this.instituicaoBancaria = instituicaoBancaria;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public Double consultarSaldo() {
		return getSaldo();
	}

	@Override
	public void depositar(Double valor) {
		saldo = saldo + valor;
		Transacao.mensagemDeDeposito(valor, this);
	}

	public boolean isSaldoPositivo(Double valor, Double saldo) {
		if ((saldo - valor) >= 0)
			return true;
		else
			throw new SaldoInsuficienteException("O saldo é insuficiente.");
	}

	@Override
	public String toString() {
		return "Número da conta: " + numeroConta + ", Instituicao Bancaria: " + instituicaoBancaria + ", Saldo: R$"
				+ saldo;
	}

}

class GeradorConta {
	private static Integer ID = 1;

	public static Integer getProximaConta() {
		return ID++;
	}
}
