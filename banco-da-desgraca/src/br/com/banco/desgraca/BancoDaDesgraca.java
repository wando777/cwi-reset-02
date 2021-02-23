package br.com.banco.desgraca;

import java.time.LocalDate;

import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;

public class BancoDaDesgraca {

	public static void main(String[] args) throws Exception {

//		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		ContaCorrente cc1 = new ContaCorrente(InstituicaoBancaria.BANCO_DO_BRASIL);
		ContaCorrente cc2 = new ContaCorrente(InstituicaoBancaria.ITAU);
		ContaDigital cd1 = new ContaDigital(InstituicaoBancaria.NUBANK);
		ContaPoupanca cp1 = new ContaPoupanca(InstituicaoBancaria.BRADESCO);

		System.out.println(cc1.toString());
		System.out.println(cc2.toString());
		System.out.println(cd1.toString());
		System.out.println(cp1.toString());
		System.out.println("*".repeat(77));

		cc1.setSaldo(1000d);
		cc1.sacar(15d);
		cc1.depositar(3d);
		cc1.transferir(15d, cp1);
		cc1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 8, 1));
		System.out.println(cc1);
		System.out.println("*".repeat(77));

		cd1.setSaldo(7777d);
		cd1.sacar(10d);
		cd1.transferir(150d, cp1);
		cd1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2021, 7, 7));
		System.out.println(cd1);
		System.out.println("*".repeat(77));

		cp1.sacar(50d);
		cp1.transferir(10d, cd1);
		cp1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2021, 7, 7));
		System.out.println(cp1);
		System.out.println("*".repeat(77));
		
		//Testando exceptions
//		cd1.sacar(9d);
//		cp1.sacar(49d);

	}
}
