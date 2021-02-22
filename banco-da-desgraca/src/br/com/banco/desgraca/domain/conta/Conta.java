package br.com.banco.desgraca.domain.conta;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enums.TipoConta;
import br.com.banco.desgraca.domain.enums.TipoTransacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.instituicaoBancariaInvalidaException;
import br.com.banco.desgraca.utils.Data;
import br.com.banco.desgraca.utils.Utils;

public abstract class Conta implements ContaBancaria {

	private Integer numeroConta;

	private InstituicaoBancaria instituicaoBancaria;

	private Double saldo;

	private TipoConta tipo;

	protected List<Transacao> transacoes = new ArrayList<Transacao>();

	// private ListaContas listaContas;

	public Conta() {
	}

	public Conta(InstituicaoBancaria instituicaoBancaria) {
		this.instituicaoBancaria = instituicaoBancaria;
		this.saldo = 0d;
		numeroConta = Utils.getProximaConta();
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

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public Double consultarSaldo() {
		return getSaldo();
	}

	@Override
	public void depositar(Double valor) {
		saldo = saldo + valor;
		mensagemDeDeposito(valor, this);
		transacoes.add(new Transacao(this, TipoTransacao.DEPOSITO, Data.getDataTransacao(), valor));
	}

//	public void receberTransferencia(Double valor) {
//		saldo = saldo + valor;
//		transacoes.add(new Transacao(this, TipoTransacao.DEPOSITO, Data.getDataTransacao(), valor));
//	}

	@Override
	public void exibirExtrato(LocalDate inicio, LocalDate fim) {
		transacoes.forEach((t) -> {
			if (t.getDataDaTransacao().compareTo(inicio) >= 0 && t.getDataDaTransacao().compareTo(fim) <= 0) {
				System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
				System.out.println(t.toString());
			}
		});
	}

//	private static void filtrarExtrato(LocalDate inicio, LocalDate fim, Transacao t) {
//		if (t.getDataDaTransacao().compareTo(inicio) > 0 && t.getDataDaTransacao().compareTo(fim) < 0) {
//			System.out.println(t.toString());
//		}
//	}

	public boolean isSaldoPositivo(Double valor, Double saldo) {
		if ((saldo - valor) >= 0)
			return true;
		else
			throw new SaldoInsuficienteException("O saldo é insuficiente.");
	}

	public boolean isMesmaConta(ContaBancaria contaDestino) {
		if (contaDestino.equals(this))
			throw new instituicaoBancariaInvalidaException("Não pode transferir para a mesma conta.");
		else
			return false;
	}

	@Override
	public String toString() {
		return "\nNúmero da conta:" + numeroConta + ", Instituição Bancária: " + instituicaoBancaria.getDescricao()
				+ ", Saldo: " + DecimalFormat.getCurrencyInstance().format(saldo);
	}

	/**
	 * Métodos estáticos para impressão das mensagens de transação
	 */

	public static void mensagemDeSaque(Double valor, Conta conta) {
		System.out.println("Sacou " + DecimalFormat.getCurrencyInstance().format(valor) + " da conta "
				+ conta.getTipo().getDescricao() + " " + conta.getInstituicaoBancaria().getDescricao() + " número: "
				+ conta.getNumeroConta());
	}

	public static void mensagemDeDeposito(Double valor, Conta conta) {
		System.out.println("Depositou " + DecimalFormat.getCurrencyInstance().format(valor) + " na conta "
				+ conta.getTipo().getDescricao() + " " + conta.getInstituicaoBancaria().getDescricao() + " número: "
				+ conta.getNumeroConta());
	}

	public static void mensagemDeTransfererencia(Double valor, Conta conta, Conta destino) {
		System.out.println("Transferiu " + DecimalFormat.getCurrencyInstance().format(valor) + " da conta "
				+ conta.getTipo().getDescricao() + " " + conta.getInstituicaoBancaria().getDescricao() + " número: "
				+ conta.getNumeroConta() + " para " + destino.getTipo().getDescricao() + " "
				+ destino.getInstituicaoBancaria().getDescricao() + " número: " + destino.getNumeroConta());
	}

	public static void mensagemDeTaxa(Double valor) {
		System.out
				.println("Essa tranferência custou " + DecimalFormat.getCurrencyInstance().format(valor) + " em taxas");
	}

}
