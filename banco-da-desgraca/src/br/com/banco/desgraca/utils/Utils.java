package br.com.banco.desgraca.utils;

import java.util.Random;

public class Utils {
	
	 public static int getRandomNumberRange(int min, int max) {
	        Random r = new Random();
	        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	    }

}
