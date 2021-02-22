package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enums.TipoConta;
import br.com.banco.desgraca.domain.enums.TipoTransacao;
import br.com.banco.desgraca.exception.instituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;
import br.com.banco.desgraca.utils.Data;

public class ContaPoupanca extends Conta {

	private static final Double TAXA_TRANSFERENCIA_OUTROS_BANCOS = 0.01;
	private static final Double TAXA_TRANSFERENCIA_MESMO_BANCO = 0.005;
	private static final Double TAXA_SAQUE = 0.02;
	private static final Integer SAQUE_MINIMO = 50;

	public ContaPoupanca(InstituicaoBancaria instituicaoBancaria) {
		super(instituicaoBancaria);
		if (instituicaoBancaria == InstituicaoBancaria.NUBANK) {
			throw new instituicaoBancariaInvalidaException("Esta instituição não possui conta poupança");
		}
		setTipo(TipoConta.POUPANCA);
	}

	@Override
	public void sacar(Double valor) {
		if (valor < SAQUE_MINIMO) {
			throw new valorMinimoParaSaqueException("O valor para saque deve ser superior a R$" + SAQUE_MINIMO);
		}
		Double taxa = valor * TAXA_SAQUE;
		isSaldoPositivo(valor + taxa, getSaldo());
		setSaldo(getSaldo() - (valor + taxa));
		mensagemDeSaque(valor, this);
		transacoes.add(new Transacao(this, TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		isMesmaConta(contaDestino);
		Double taxa = contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()
				? valor * TAXA_TRANSFERENCIA_OUTROS_BANCOS
				: valor * TAXA_TRANSFERENCIA_MESMO_BANCO;
		isSaldoPositivo(valor + taxa, getSaldo());
		setSaldo(getSaldo() - (valor + taxa));
		mensagemDeTransfererencia(valor, this, (Conta) contaDestino);
		mensagemDeTaxa(taxa);
		transacoes.add(new Transacao(this, TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
	}

	@Override
	public String toString() {
		return "Conta Poupança: " + super.toString();
	}

}
