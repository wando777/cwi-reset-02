package br.com.banco.desgraca.domain.conta;

import java.time.LocalDate;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;

public class ContaCorrente extends Conta {

	private static final Double TAXA_TRANSFERENCIA_OUTROS_BANCOS = 0.1;
	private static final Integer DIVISOR_SAQUE = 5;

	public ContaCorrente(InstituicaoBancaria instituicaoBancaria) {
		super(instituicaoBancaria);
		setTipo(TipoConta.CORRENTE);
	}

	@Override
	public void sacar(Double valor) {
		if (valor >= 5 && valor % DIVISOR_SAQUE > 0) {
			throw new valorMinimoParaSaqueException("Valor a ser sacado precisa ser múltiplo e maior que 5");
		}
		isSaldoPositivo(valor, getSaldo());
		setSaldo(getSaldo() - valor);
		Transacao.mensagemDeSaque(valor, this);
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		isSaldoPositivo(valor, getSaldo());
		if (contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()) {
			Double taxa = valor * TAXA_TRANSFERENCIA_OUTROS_BANCOS;
			isSaldoPositivo(valor + taxa, getSaldo());
			setSaldo(getSaldo() - (valor + taxa));
			System.out.println("Essa tranferência custou R$" + taxa + " de taxas.");
		} else {
			setSaldo(getSaldo() - valor);
		}
		contaDestino.depositar(valor);
	}

	@Override
	public void exibirExtrato(LocalDate inicio, LocalDate fim) {

	}

	@Override
	public String toString() {
		return "ContaCorrente: " + super.toString();
	}

}
