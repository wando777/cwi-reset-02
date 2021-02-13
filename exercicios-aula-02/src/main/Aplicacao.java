package main;

import models.Diretor;
import models.Filme;

public class Aplicacao {

	public static void main(String[] args) {

		//Diretor d1 = new Diretor(Input.leString("Digite o nome do diretor:  "), 50, 10);
		Diretor d1 = new Diretor("Carlos", 50, 10);
		Filme f1 = new Filme("Lord of the rings", "The best movie made ever", 300, 2000, 5, d1);
		Filme f2 = new Filme("Lord of the rings 2", "The best movie made ever", 300, 2000, 5, d1);

		System.out.println(f1.reproduzirFilme());
		System.out.println("-------x-------");
		System.out.println(f2.reproduzirFilme());

	}

}
