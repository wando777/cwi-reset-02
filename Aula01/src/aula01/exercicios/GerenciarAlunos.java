package aula01.exercicios;

import java.util.ArrayList;

import aula01.exercicios.status.SituacaoAluno;

public class GerenciarAlunos {

	private String nome;
	private ArrayList<Double> notas;
	private SituacaoAluno situacao;

	public GerenciarAlunos(String nome, ArrayList<Double> notas) {
		this.nome = nome;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	public SituacaoAluno getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoAluno situacao) {
		this.situacao = situacao;
	}

	public double getNotaFinal() {
		double sum = 0;
		for (Double x : notas) {
			sum += x;
		}
		return sum / notas.size();
	}

	public SituacaoAluno getSituacaoFinal() {
		if (getNotaFinal() >= 7) {
			return SituacaoAluno.APROVADO;
		}
		return SituacaoAluno.REPROVADO;
	}

}
