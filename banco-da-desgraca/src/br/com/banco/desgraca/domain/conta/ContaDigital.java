package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enums.TipoConta;
import br.com.banco.desgraca.domain.enums.TipoTransacao;
import br.com.banco.desgraca.exception.instituicaoBancariaInvalidaException;
import br.com.banco.desgraca.utils.Data;

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
		isSaqueMinimo(valor, SAQUE_MINIMO);
		isSaldoPositivo(valor, getSaldo());
		setSaldo(getSaldo() - valor);
		mensagemDeSaque(valor, this);
		transacoes.add(new Transacao(this, TipoTransacao.SAQUE, Data.getDataTransacao(), valor));
	}

	@Override
	public void transferir(Double valor, ContaBancaria contaDestino) {
		isSaldoPositivo(valor, getSaldo());
		isMesmaConta(contaDestino);
		setSaldo(getSaldo() - valor);
		mensagemDeTransfererencia(valor, this, (Conta) contaDestino);
		contaDestino.depositar(valor);
		transacoes.add(new Transacao(this, TipoTransacao.TRANSFERENCIA, Data.getDataTransacao(), valor));
	}

	@Override
	public String toString() {
		return "Conta Digital: " + super.toString();
	}

}
