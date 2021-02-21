package com;

import com.company.entidades.Editora;
import com.company.entidades.Endereco;

public class Main {

    public static void main(String[] args) {
    	
    	Endereco end1 = new Endereco("a", "123", "b", "c");

    	Editora e1 = new Editora("Teste", end1);
    	Editora e2 = new Editora("DC Comics", end1);
    	
    	System.out.println(e1.toString());
    	//System.out.println(e2.toString());
    }
}
