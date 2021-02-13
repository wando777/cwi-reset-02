package br.com.minha_casa_minha_desgraca.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Beneficiario {

	private String nomeBeneficiario;
	private double salarioBeneficiario;

	public Beneficiario(String nomeBeneficiario, double salarioBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
		this.salarioBeneficiario = salarioBeneficiario;
	}

}
