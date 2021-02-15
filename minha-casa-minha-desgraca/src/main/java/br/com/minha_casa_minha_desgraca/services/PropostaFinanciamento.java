package br.com.minha_casa_minha_desgraca.services;

import br.com.minha_casa_minha_desgraca.models.Beneficiario;
import br.com.minha_casa_minha_desgraca.models.Imovel;
import br.com.minha_casa_minha_desgraca.models.enums.UnidadeFederativa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PropostaFinanciamento {

	private Beneficiario beneficiario;
	private Imovel imovel;
	private int mesesParaPagamento;

	private static final double PORCENTAGEM_PISO_PROPOSTA = 0.5;
	private static final double PORCENTAGEM_PISO_PROPOSTA_SP = 0.65;
	private static final double PORCENTAGEM_PISO_PROPOSTA_RJ = 0.6;

	public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int mesesParaPagamento) {
		this.beneficiario = beneficiario;
		this.imovel = imovel;
		this.mesesParaPagamento = mesesParaPagamento;
	}

	/**
	 * Valida a proposta de financiamento e apresenta o resultado para o cliente.
	 *
	 * A proposta de financiamento é aceita somente se o salário do beneficiário
	 * multiplicado pelo prazo de pagamento for equivalente a pelo menos 50% do
	 * valor do imóvel.
	 *
	 * Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
	 * o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor
	 * imóvel (respectivamente).
	 */
	public void validarProposta() {

		boolean excecao = imovel.getEndereco().getEstado() == UnidadeFederativa.SP ? true
				: imovel.getEndereco().getEstado() == UnidadeFederativa.RJ;
		double poderDeCompra = beneficiario.getSalarioBeneficiario() * mesesParaPagamento;

		if (excecao) {
			if (imovel.getEndereco().getEstado() == UnidadeFederativa.SP
					&& poderDeCompra >= PORCENTAGEM_PISO_PROPOSTA_SP * imovel.getValor()) {
				imprimirPropostaAprovada();
			} else if (poderDeCompra >= PORCENTAGEM_PISO_PROPOSTA_RJ * imovel.getValor()) {
				imprimirPropostaAprovada();
			} else {
				imprimirPropostaNegada();
			}
		} else if (poderDeCompra >= imovel.getValor() * PORCENTAGEM_PISO_PROPOSTA) {
			imprimirPropostaAprovada();
		} else {
			imprimirPropostaNegada();
		}
	}

	private void imprimirPropostaAprovada() {
		System.out.println(
				toString() + "\n" + "Parabéns, sua proposta foi aceita! Agora você tem uma dívida pro resto da vida!");
	}

	private void imprimirPropostaNegada() {
		System.out.println(toString() + "\n"
				+ "Que pena, sua proposta foi negada, mas olhe pelo lado bom, pelo menos você não está endividado pra sempre!");
	}

	@Override
	public String toString() {
		return "Beneficiario: " + beneficiario.getNomeBeneficiario() + "\n" + "Imovel: " + imovel.apresentacao() + "\n"
				+ "Meses para pagamento: " + mesesParaPagamento;
	}

}
