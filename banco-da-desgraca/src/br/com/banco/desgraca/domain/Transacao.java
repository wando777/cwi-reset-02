package br.com.banco.desgraca.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.banco.desgraca.domain.conta.Conta;
import br.com.banco.desgraca.domain.enums.TipoTransacao;
import br.com.banco.desgraca.utils.Utils;

public class Transacao {

	private Integer id;
	private TipoTransacao tipoTransacao;
	private LocalDate dataDaTransacao;
	private Double valorDaTransacao;
	private Conta conta;

	public Transacao(Conta conta, TipoTransacao tipoTransacao, LocalDate dataDaTransacao, Double valorDaTransacao) {
		this.id = Utils.getProximoId();
		this.conta = conta;
		this.tipoTransacao = tipoTransacao;
		this.dataDaTransacao = dataDaTransacao;
		this.valorDaTransacao = valorDaTransacao;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public LocalDate getDataDaTransacao() {
		return dataDaTransacao;
	}

	public void setDataDaTransacao(LocalDate dataDaTransacao) {
		this.dataDaTransacao = dataDaTransacao;
	}

	public Double getValorDaTransacao() {
		return valorDaTransacao;
	}

	public void setValorDaTransacao(Double valorDaTransacao) {
		this.valorDaTransacao = valorDaTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return "Conta: " + conta.getNumeroConta() + "\n" + tipoTransacao.getDescricao() + "\nTransacao ID: " + getId()
				+ " " + "\nData:" + dataDaTransacao.format(dtf) + "\n" + "Valor: "
				+ DecimalFormat.getCurrencyInstance().format(valorDaTransacao);
	}

}
