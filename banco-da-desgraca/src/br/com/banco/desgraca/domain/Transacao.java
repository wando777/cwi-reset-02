package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.Conta;

public class Transacao {

	public static void mensagemDeSaque(Double valor, Conta conta) {
		System.out.println("Sacou R$" + valor + " da conta " + conta.getTipo() + " " + conta.getInstituicaoBancaria()
				+ " número: " + conta.getNumeroConta());
	}

	public static void mensagemDeDeposito(Double valor, Conta conta) {
		System.out.println("Depositou R$" + valor + " na conta " + conta.getTipo() + " "
				+ conta.getInstituicaoBancaria() + " número: " + conta.getNumeroConta());
	}

}
