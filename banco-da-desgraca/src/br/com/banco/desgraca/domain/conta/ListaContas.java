package br.com.banco.desgraca.domain.conta;

import java.util.HashMap;

public class ListaContas {

	HashMap<Conta, Integer> listaDeContas = new HashMap<Conta, Integer>();

	public void adicionaConta(Conta conta, Integer numeroDaConta) {
		for (Conta i : listaDeContas.keySet()) {
			if (i.getNumeroConta() != numeroDaConta) {
				throw new IllegalArgumentException("Conta já existente");
			}
			listaDeContas.put(conta, numeroDaConta);
		}
	}

}
