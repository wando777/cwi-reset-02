package models;

import java.util.List;

import exceptions.NotaInvalidaException;

public class Filme {

	private String nome;
	private String descricao;
	private Integer duracao;
	private Integer anoLancamento;
	private Integer notaAvaliacao;

	private Diretor diretor;

	private List<Pessoa> elenco;

	private static final int NOTA_MINIMA = 0;
	private static final int NOTA_MAXIMA = 5;

	public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Integer notaAvaliacao,
			Diretor diretor, List<Pessoa> elenco) {
		if (notaAvaliacao < NOTA_MINIMA || notaAvaliacao > NOTA_MAXIMA) {
			throw new NotaInvalidaException(
					"A nota é inválida, ela deve estar entre " + NOTA_MINIMA + " e " + NOTA_MAXIMA);
		}
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.notaAvaliacao = notaAvaliacao;
		this.diretor = diretor;
		this.elenco = elenco;
	}

	public Filme() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public Integer getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(Integer notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public List<Pessoa> getElenco() {
		return elenco;
	}

	public void setElenco(List<Pessoa> elenco) {
		this.elenco = elenco;
	}

	public String reproduzirFilme() {
		return "Nome do filme: " + nome + "\n" + "Descrição: " + descricao + "\n" + "Duracão: " + duracao + "\n"
				+ "Nota: " + notaAvaliacao + "\n" + diretor.toString() + "\n" + listarElenco();
	}

	public String listarElenco() {
		StringBuilder builder = new StringBuilder();
		for (Pessoa pessoa : elenco) {
			builder.append(pessoa.toString() + "\n");
//			if (pessoa instanceof Ator) {
//				builder.append("Número de Oscars: " + ((Ator) pessoa).getNumeroDeOscars() + "\n");
//			} else if (pessoa instanceof Diretor) {
//				builder.append("Número de filmes dirigidos: " + ((Diretor) pessoa).getNumeroDeFilmesDirigidos());
//			}
		}
		return "Elenco: " + "\n" + builder;
	}

}
