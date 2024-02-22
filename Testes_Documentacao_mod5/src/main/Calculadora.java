package main;

/**
 * @author bella
 * 
 * A classe Calculadora foi criada para realizar cálculos simples.
 * Soma, Subtração, Multiplicação e Divisão
 * 
 * @see CalcTest -> Para vizualizar seu funcionamento (testes)
 *  
*/


public class Calculadora {
	
	public int soma(int a, int b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mult(int a, int b) {
		return a * b;
	}
	
	public int divi(int a, int b) {
		if(b != 0) {
			return a / b;
		} else {
			throw new RuntimeException("Erro: O divisor não pode ser zero! ");
		}
	}

}
