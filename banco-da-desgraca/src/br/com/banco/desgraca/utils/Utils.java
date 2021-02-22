package br.com.banco.desgraca.utils;

import java.util.Random;

public class Utils {

	private static Integer id = 1;
	private static Integer conta = 1;

	public static int getRandomNumberRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}

	public static Integer getProximoId() {
		return id++;
	}

	public static Integer getProximaConta() {
		return conta++;
	}
}
