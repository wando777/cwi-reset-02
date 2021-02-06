package aula01;

import aula01.exercicios.OperacoesMatematicas;

public class ExerciciosMain {
	public static void main(String[] args) {
		OperacoesMatematicas opm = new OperacoesMatematicas(2, 7);

		System.out.println("Multiplicação:");
		System.out.println(opm.getMultiplicacao());
		System.out.println("Resto da divisão:");
		System.out.println(opm.getRestoDaDivisao());
		System.out.println("Maior número:");
		System.out.println(opm.getMaior());
	}

}
