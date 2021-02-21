package br.com.banco.desgraca.domain.conta;

import java.time.LocalDate;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.instituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.valorMinimoParaSaqueException;

public class ContaDigital extends Conta {

	private static final Integer SAQUE_MINIMO = 10;

	public ContaDigital(InstituicaoBancaria instituicaoBancaria) {
		super(instituicaoBancaria);
		boolean validarInstituicao = instituicaoBancaria == InstituicaoBancaria.NUBANK ? true
				: instituicaoBancaria == InstituicaoBancaria.ITAU;
		if (!validarInstituicao) {
			throw new instituicaoBancariaInvalidaException("Esta instituição não possui conta digital");
		}
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
		Transacao.mensagemDeTransfererencia(valor, this, (Conta) contaDestino);
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
