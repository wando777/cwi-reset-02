package aula01;

import java.util.ArrayList;

import aula01.exercicios.GerenciarAlunos;
import aula01.exercicios.OperacoesMatematicas;
import br.edu.unifacisa.si.p2.input.Input;

public class ExerciciosMain {
	public static void main(String[] args) {

		OperacoesMatematicas opm = new OperacoesMatematicas(Input.leInt("Digite um inteiro: "),
				Input.leInt("Digite outro inteiro: "));

		System.out.println("Multiplicação: " + opm.getMultiplicacao());
		System.out.println("Resto da divisão: " + opm.getRestoDaDivisao());
		System.out.println("Maior número: " + opm.getMaior());
		System.out.println("Menor número: " + opm.getMenor());

		
		//--------------------xExercício 3x----------------------
		System.out.println();
		System.out.println("Exercício 3:");
		ArrayList<Double> listaDeNotas = new ArrayList<Double>();
		listaDeNotas.add((double) 9.7);
		listaDeNotas.add((double) 9.2);
		listaDeNotas.add((double) 8.9);

		GerenciarAlunos ga = new GerenciarAlunos("aaaa", listaDeNotas);
		System.out.println("A nota final do Aluno foi: " + ga.getNotaFinal());
		System.out.println("O aluno foi: " + ga.getSituacaoFinal());

	}

}
