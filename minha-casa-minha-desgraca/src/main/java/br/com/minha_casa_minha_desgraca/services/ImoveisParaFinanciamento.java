package br.com.minha_casa_minha_desgraca.services;

import java.util.ArrayList;
import java.util.List;

import br.com.minha_casa_minha_desgraca.models.Imovel;

public class ImoveisParaFinanciamento {

	private List<Imovel> imoveis;

	public ImoveisParaFinanciamento() {
		imoveis = new ArrayList<Imovel>();
	}

	/**
	 * Registra um imóvel como opção de financiamento. O imóvel só pode ser aceito
	 * se o valor dele for maior ou igual a R$ 50.000,00 e menor ou igual a R$
	 * 1.000.000,00.
	 *
	 * Obs.: quando o valor do imóvel não estiver na faixa solicitada, deve ser
	 * apresentada a seguinte mensagem (substituindo XXX pelo valor do imóvel): " >
	 * Atenção, problema de registro! Imóveis com valor R$ XXX não são aceitos no
	 * programa."
	 */
	public void registrarImovel(Imovel imovel) {

		// se "imovel" corresponder às regras, adicioná-lo à lista "imoveis" com o
		// seguinte código:
		// imoveis.add(imovel);
	}

	/**
	 * Retorna opções de financiamento cujo valor do imóvel seja inferior ou igual
	 * ao valor limite que foi informado.
	 */
	public List<Imovel> buscarOpcoes(double valorLimite) {

		List<Imovel> opcoes = new ArrayList<Imovel>();

		// percorre a lista de imóveis
		for (Imovel imovel : imoveis) {

			// se "imovel" corresponder às regras, adicioná-lo à lista de opcoes com o
			// seguinte código:
			// opcoes.add(imovel);
		}

		return opcoes;
	}

}
