package models;

public class Filme {

	private String nome;
	private String descricao;
	private Integer duracao;
	private Integer anoLancamento;
	private Integer notaAvaliacao;

	private Diretor diretor;

	public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Diretor diretor) {
		this.nome = nome;
		this.descricao = descricao;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.diretor = diretor;
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
	
	public String reproduzirFilme() {
		return "Nome do filme: " + nome + "\n" + 
				"Descrição: " + descricao + "\n" +
				"Duracão: " + duracao + "\n" +
				"Diretor: " + diretor.getNome();
	}

}
