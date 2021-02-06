package aula01.exercicios;

public class OperacoesMatematicas {

	private int num1;
	private int num2;

	public OperacoesMatematicas(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getMultiplicacao() {
		return num1 * num2;
	}

	public int getRestoDaDivisao() {
		return num1 % num2;
	}

	public int getMaior() {
		if (num1 >= num2) {
			return num1;
		}
		return num2;
	}

	public int getMenor() {
		return num1 == getMaior() ? num2 : num1;
	}

}
