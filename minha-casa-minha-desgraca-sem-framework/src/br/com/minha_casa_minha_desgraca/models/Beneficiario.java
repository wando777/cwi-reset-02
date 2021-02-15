package br.com.minha_casa_minha_desgraca.models;

public class Beneficiario {

	private String nomeBeneficiario;
	private double salarioBeneficiario;

	public Beneficiario(String nomeBeneficiario, double salarioBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
		this.salarioBeneficiario = salarioBeneficiario;
	}

	public Beneficiario() {
	}

	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}

	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}

	public double getSalarioBeneficiario() {
		return salarioBeneficiario;
	}

	public void setSalarioBeneficiario(double salarioBeneficiario) {
		this.salarioBeneficiario = salarioBeneficiario;
	}

}
