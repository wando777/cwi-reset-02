package br.com.minha_casa_minha_desgraca.services;

import br.com.minha_casa_minha_desgraca.models.Beneficiario;
import br.com.minha_casa_minha_desgraca.models.Imovel;

public class PropostaFinanciamento {
	
	 public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
		// TODO Auto-generated constructor stub
	}

	/**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {

    }

}
