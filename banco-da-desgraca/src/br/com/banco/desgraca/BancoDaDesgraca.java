package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

    	ContaCorrente cc1 = new ContaCorrente(InstituicaoBancaria.NUBANK);
    	ContaCorrente cc2 = new ContaCorrente(InstituicaoBancaria.ITAU);
    	ContaDigital cd1 = new ContaDigital(InstituicaoBancaria.NUBANK);

    	System.out.println(cc1.toString());
    	System.out.println(cc2.toString());
    	System.out.println(cd1.consultarSaldo());
    	cd1.setSaldo(100d);
    	cd1.sacar(10d);
    	cd1.transferir(50d, cc1);
    	System.out.println(cd1);
    	System.out.println(cc1);
    	cc1.sacar(15d);
    	System.out.println(cc1);
    	cc1.transferir(20d, cc2);
    	System.out.println(cc1);
    	System.out.println(cc2);
    	cc1.transferir(3d, cd1);
    	System.out.println(cd1);
    	System.out.println(cc1);
    }
}
