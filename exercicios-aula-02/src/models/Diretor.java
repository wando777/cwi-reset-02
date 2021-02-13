package models;

public class Diretor {

	private String nome;
	private Integer idade;
	private Integer numeroDeFilmesDirigidos;

	public Diretor(String nome, Integer idade, Integer numeroDeFilmesDirigidos) {
		this.nome = nome;
		this.idade = idade;
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
	}

	public Diretor() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getNumeroDeFilmesDirigidos() {
		return numeroDeFilmesDirigidos;
	}

	public void setNumeroDeFilmesDirigidos(Integer numeroDeFilmesDirigidos) {
		this.numeroDeFilmesDirigidos = numeroDeFilmesDirigidos;
	}

}
