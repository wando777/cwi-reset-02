package br.com.banco.desgraca.domain.conta;

import java.time.LocalDate;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.instituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;

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
		Transacao.mensagemDeSaque(valor, this);
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		Double taxa = contaDestino.getInstituicaoBancaria() != this.getInstituicaoBancaria()
				? valor * TAXA_TRANSFERENCIA_OUTROS_BANCOS
				: valor * TAXA_TRANSFERENCIA_MESMO_BANCO;
		isSaldoPositivo(valor + taxa, getSaldo());
		setSaldo(getSaldo() - (valor + taxa));
		System.out.println("Essa tranferência custou R$" + taxa + " de taxas.");
		Transacao.mensagemDeTransfererencia(valor, this, (Conta) contaDestino);
	}

	@Override
	public void exibirExtrato(LocalDate inicio, LocalDate fim) {
		// TODO Auto-generated method stub

	}

}
