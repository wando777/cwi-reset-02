package br.com.minha_casa_minha_desgraca;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.minha_casa_minha_desgraca.models.Apartamento;
import br.com.minha_casa_minha_desgraca.models.Beneficiario;
import br.com.minha_casa_minha_desgraca.models.Casa;
import br.com.minha_casa_minha_desgraca.models.Endereco;
import br.com.minha_casa_minha_desgraca.models.Imovel;
import br.com.minha_casa_minha_desgraca.models.enums.UnidadeFederativa;
import br.com.minha_casa_minha_desgraca.services.ImoveisParaFinanciamento;
import br.com.minha_casa_minha_desgraca.services.PropostaFinanciamento;

public class MinhaCasaMinhaDesgraca {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		System.out.println("\n ### Olá, seja bem vindo ao magnífico programa Minha Casa - Minha Desgraça ###\n");

		ImoveisParaFinanciamento opcoesParaFinanciamento = new ImoveisParaFinanciamento();

		/**
		 * INÍCIO
		 *
		 * NÃO MODIFICAR ESTA CLASSE ANTES DESTA LINHA.
		 */

		/**
		 * Endereços genéricos, afinal, as casas nsses lotes do governo são todas juntas
		 * mesmo.
		 */
		Endereco e1 = new Endereco("Igual", "111", "Muito longe", "Genérica", UnidadeFederativa.PB);
		Endereco e2 = new Endereco("Idêntica", "123", "Muito longe", "Genérica", UnidadeFederativa.RJ);
		Endereco e3 = new Endereco("Parecida", "321", "Muito longe", "Genérica", UnidadeFederativa.SP);

		Imovel i1 = new Casa(150000.00, e1, false);
		Imovel i2 = new Apartamento(500000.00, e2, "Sétimo");
		Imovel i3 = new Casa(250000.00, e3, true);

		opcoesParaFinanciamento.registrarImovel(i1);
		opcoesParaFinanciamento.registrarImovel(i2);
		opcoesParaFinanciamento.registrarImovel(i3);

		/**
		 * FIM
		 *
		 * NÃO MODIFICAR ESTA CLASSE APÓS ESTA LINHA.
		 */

		List<Imovel> todasAsOpcoes = opcoesParaFinanciamento.buscarOpcoes(Double.MAX_VALUE);
		if (todasAsOpcoes == null || todasAsOpcoes.isEmpty()) {
			throw new RuntimeException(
					"\n\nAtenção! Você precisa registrar opções de financiamento antes de começar a usar o programa.\n"
							+ "Use o método 'registrarImovel', do objeto 'opcoesParaFinanciamento', para incluir algumas opções.\n");
		}

		System.out.println("\nVamos lá, preciso de algumas respostas...\n");
		Thread.sleep(1000);

		System.out.println(" 	Qual é o teu nome?");
		String nomeBeneficiario = new Scanner(System.in).next();
		Thread.sleep(500);

		System.out.println(" Agora eu preciso saber sobre a mascada, " + nomeBeneficiario + ". Qual é o teu salário?");
		double salarioBeneficiario = new Scanner(System.in).nextDouble();
		Thread.sleep(500);

		Beneficiario beneficiario = new Beneficiario(nomeBeneficiario, salarioBeneficiario);

		System.out.println(" Hummmm, tá grandão hein. E qual é o limite do valor de imóveis que você procura?");
		double valorParaPesquisa = new Scanner(System.in).nextDouble();
		Thread.sleep(500);

		System.out.println("\nTá, deixa eu ver aqui o que eu tenho de opções até "
				+ DecimalFormat.getCurrencyInstance().format(valorParaPesquisa) + "...");
		Thread.sleep(new Random().nextInt(4000) + 1000);

		List<Imovel> opcoesViaveis = opcoesParaFinanciamento.buscarOpcoes(valorParaPesquisa);
		if (opcoesViaveis == null || opcoesViaveis.isEmpty()) {
			throw new RuntimeException(
					"\n\nPQP! Essa desgraça de programa não tem casas neste valor! Comece uma nova simulação.");
		}

		System.out.println("\nCerto! Encontrei " + opcoesViaveis.size() + " opções aqui. Dá uma olhada:");
		int index = 0;
		for (Imovel imovel : opcoesViaveis) {
			System.out.printf(" [%d] %s\n", ++index, imovel.apresentacao());
			Thread.sleep(250);
		}

		Imovel imovelEscolhido = null;
		while (imovelEscolhido == null) {

			Thread.sleep(250);

			System.out.println("\nQual a opção que mais te agrada? (Me diz apenas o número.)");
			int opcaoEscolhida = new Scanner(System.in).nextInt();

			Thread.sleep(250);

			if (opcaoEscolhida < 1 || opcaoEscolhida > opcoesViaveis.size()) {
				System.out.println(" > Opção inválida!");
			} else {
				imovelEscolhido = opcoesViaveis.get(opcaoEscolhida - 1);
			}
		}

		System.out.println("\nShow de bola! Agora me diz em quantos meses você quer pagar essa tranqueira:");
		int mesesParaPagamento = new Scanner(System.in).nextInt();

		System.out.printf(
				"\nHumm, certo %s. Você ganha %s e quer financiar um imóvel de %s, no estado %s, pagando em %d meses. Deixa eu ver se é possível...\n\n",
				beneficiario.getNomeBeneficiario(),
				DecimalFormat.getCurrencyInstance().format(beneficiario.getSalarioBeneficiario()),
				DecimalFormat.getCurrencyInstance().format(imovelEscolhido.getValor()),
				imovelEscolhido.getEndereco().getEstado(), mesesParaPagamento);
		Thread.sleep(new Random().nextInt(4000) + 1000);

		PropostaFinanciamento financiamento = new PropostaFinanciamento(beneficiario, imovelEscolhido,
				mesesParaPagamento);
		financiamento.validarProposta();
	}
}