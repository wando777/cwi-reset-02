package br.com.banco.desgraca.domain.conta;

import java.time.LocalDate;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;

public class ContaDigital extends Conta {

	private static final Integer SAQUE_MINIMO = 10;

	public ContaDigital(InstituicaoBancaria instituicaoBancaria) {
		super(instituicaoBancaria);
		setTipo(TipoConta.DIGITAL);
	}

	@Override
	public void sacar(Double valor) {
		if (valor < SAQUE_MINIMO) {
			throw new valorMinimoParaSaqueException("O valor para saque deve ser superior a R$" + SAQUE_MINIMO);
		}
		isSaldoPositivo(valor, getSaldo());
		setSaldo(getSaldo() - valor);
		Transacao.mensagemDeSaque(valor, this);
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		isSaldoPositivo(valor, getSaldo());
		setSaldo(getSaldo() - valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void exibirExtrato(LocalDate inicio, LocalDate fim) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "ContaDigital: " + super.toString();
	}

}
