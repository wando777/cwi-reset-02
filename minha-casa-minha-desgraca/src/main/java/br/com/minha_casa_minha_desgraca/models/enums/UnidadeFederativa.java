package br.com.minha_casa_minha_desgraca.models.enums;

import lombok.Getter;

@Getter
public enum UnidadeFederativa {
	//AC, AL, AP, AM, BA, CE, ES, GO, MA, MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO, DF;

	 	AC("Acre"),
	    AL("Alagoas"),
	    AP("Amapá"),
	    AM("Amazonas"),
	    BA("Bahia"),
	    CE("Ceará"),
	    DF("Distrito Federal"),
	    ES("Espíríto Santo"),
	    GO("Goiás"),
	    MA("Maranhão"),
	    MT("Mato Grosso"),
	    MS("Mato Grosso do Sul"),
	    MG("Minas Gerais"),
	    PA("Pará"),
	    PB("Paraíba"),
	    PR("Paraná"),
	    PE("Pernambuco"),
	    PI("Piauí"),
	    RJ("Rio de Janeiro"),
	    RN("Rio Grande do Norte"),
	    RS("Rio Grande do Sul"),
	    RO("Rondônia"),
	    RR("Roraima"),
	    SC("Santa Catarina"),
	    SP("São Paulo"),
	    SE("Sergipe"),
	    TO("Tocantins");
	
	private String nome;

	UnidadeFederativa(String nome) {
		this.nome = nome;
	}

}
