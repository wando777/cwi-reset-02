package br.com.banco.desgraca;

import java.text.DecimalFormat;
import java.time.LocalDate;

import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.enums.InstituicaoBancaria;

public class BancoDaDesgraca {

	public static void main(String[] args) throws Exception {

//		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		ContaCorrente cc1 = new ContaCorrente(InstituicaoBancaria.NUBANK);
		ContaCorrente cc2 = new ContaCorrente(InstituicaoBancaria.ITAU);
		ContaDigital cd1 = new ContaDigital(InstituicaoBancaria.NUBANK);

		System.out.println(cc1.toString());
//    	System.out.println(cc2.toString());
//    	System.out.println(cd1.consultarSaldo());
		cc1.setSaldo(100d);
		cc1.sacar(10d);
		cc1.sacar(15d);
		cc1.sacar(5d);
		cc1.sacar(10d);
		cc1.sacar(55d);
		cc1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 7, 21));
//		cc1.transferir(50d, cc2);
//		cc2.exibirExtrato(null, null);
//    	System.out.println(cd1);
//    	System.out.println(cc1);
//    	cc1.sacar(15d);
//    	System.out.println(cc1);
//    	cc1.transferir(20d, cc2);
//    	System.out.println(cc1);
//    	System.out.println(cc2);
//    	cc1.transferir(3d, cd1);
//    	System.out.println(cd1);
//    	System.out.println(cc1);

		
//		System.out.println(LocalDate.now().compareTo(LocalDate.parse("22-02-2021", sdf)));
//    	System.out.println(Data.getDataTransacao());
//    	System.out.println(Data.getDataTransacao());
//    	System.out.println(Data.getDataTransacao());
//    	System.out.println(Data.getDataTransacao());
		

//		System.out.println(DecimalFormat.getCurrencyInstance().format());
		
	}
}
