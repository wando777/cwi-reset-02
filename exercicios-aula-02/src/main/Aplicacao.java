package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import models.Ator;
import models.Diretor;
import models.Filme;
import models.Pessoa;
import models.enums.Genero;

public class Aplicacao {

	public static void main(String[] args) {
		
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dataNascimento = LocalDate.parse("15-06-1993", sdf);

//		Diretor d1 = new Diretor(Input.leString("Digite o nome do diretor: "), 50, 10);
		Diretor d1 = new Diretor("Carlos", dataNascimento, 10, Genero.MASCULINO);
		Ator a1 = new Ator("Petter", dataNascimento, Genero.NAO_BINARIO, 7);
		Ator a2 = new Ator("Luc", dataNascimento, Genero.MASCULINO, 5);
		Ator a3 = new Ator("Sam", dataNascimento, Genero.MASCULINO, 9);

		List<Pessoa> elenco = List.of(a1, a2, a3);

		Filme f1 = new Filme("Lord of the rings", "The best movie ever made", 300, 2000, 5, d1, elenco);
		// Filme f2 = new Filme("Lord of the rings 2", "The best movie ever made", 300,
		// 2000, 5, d1);

//		System.out.println(f1.reproduzirFilme());
//		System.out.println("-------x-------");
//		System.out.println(f2.reproduzirFilme());
//		System.out.println("-------x-------");
//		System.out.println("Diretor: " + "\n" + d1);
//		System.out.println("-------x-------");
//		System.out.println("Ator: " + "\n" + a1);

		System.out.println(f1.reproduzirFilme());

	}

}
