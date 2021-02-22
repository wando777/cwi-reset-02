package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enums.TipoConta;
import br.com.banco.desgraca.domain.enums.TipoTransacao;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;
import br.com.banco.desgraca.utils.Data;

public class ContaCorrente extends Conta {

	private static final Double TAXA_TRANSFERENCIA_OUTROS_BANCOS = 0.01;
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
		mensagemDeSaque(valor, this);
		transacoes.add(new Transacao(this, TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		isSaldoPositivo(valor, getSaldo());
		isMesmaConta(contaDestino);
		if (contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()) {
			Double taxa = valor * TAXA_TRANSFERENCIA_OUTROS_BANCOS;
			isSaldoPositivo(valor + taxa, getSaldo());
			setSaldo(getSaldo() - (valor + taxa));
			mensagemDeTaxa(taxa);
		} else {
			setSaldo(getSaldo() - valor);
		}
		contaDestino.depositar(valor);
		mensagemDeTransfererencia(valor, this, (Conta) contaDestino);
		transacoes.add(new Transacao(this, TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
	}

	@Override
	public String toString() {
		return "Conta Corrente: " + super.toString();
	}

}
