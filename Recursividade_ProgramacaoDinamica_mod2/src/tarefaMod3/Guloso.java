package tarefaMod3;

/*
 * Exercício 2 - Resolva o problema usando um algoritmo guloso
 * Você tem que dar o troco de uma quantia em dinheiro usando o menor número possível de moedas.
 * 
 * Exemplos:
 * Entrada: Quantia 18, Moedas disponíveis 5, 2 e 1
 * Saída: 5 (três moedas de cinco, uma de 2 e uma de 1)
 * 
*/

public class Guloso {

	public static void main(String[] args) {
		int[] moedas = { 5, 2, 1 };
		int valor = 18;
		int[] troco = calcTroco(moedas, valor);

		for (int i = 0; i < moedas.length; i++) {
			System.out.println(troco[i] + " moedas de " + moedas[i] + " centavos");
		}
	}

	public static int[] calcTroco(int[] moedas, int valor) {
		int troco[] = new int[moedas.length];
		for (int i = 0; i < moedas.length; i++) {
			troco[i] = valor / moedas[i];
			valor %= moedas[i];
		}
		
		return troco;

	}

}
