package tarefaMod2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tarefa {
	
	private static Map<Integer, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) {
		
		/*
		 * Exercício 1 – Resolva o problema usando recursão
		 * 
		*/
		
		Scanner input = new Scanner(System.in);
		System.out.println("Adicione um número inteiro: ");
		int num = input.nextInt();
		int fator = 1;
		for (int i = 1; i <= num; i++) {
			fator *= i;
		}
		System.out.println("Fatorial de " + num + " é " + fator);
		
		
		/*
		 * Exercício 2 – Resolva o problema programação dinâmica 
		 * abordagem top down e outro com bottom up 
		 * 
		*/
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int n = scan.nextInt();
		
		// Usando top down
		System.out.print("Top-Down: " + calcFatorTopDown(n));
		
		System.out.print(" ");
		
		// Usando bottom up
		System.out.print("Bottom-Up: " + calcFatorBottomUp(n));

		input.close();
		scan.close();
		
	}

	private static int calcFatorTopDown(int n) {
		if(n < 0) {
            return 0; 
        }
		if(n == 0 || n == 1) {
			return 1;
		}
		
		if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int resul = n * calcFatorTopDown(n - 1);
        memo.put(n, resul);       
        return resul;
		
	}
	
	private static int calcFatorBottomUp(int n) {
		if(n < 0) {
            return 0; 
        }
		int[] dp = new int[n + 1];
		dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
        	dp[i] = i * dp[i - 1];
        }
        return dp[n];
    }
	
//	Exercício 3 – Compare as soluções apresentadas
	
	/*
	 * Solução Recursiva (Exercício 1 - Fatorial):
	 * A complexidade de tempo é exponencial, O(2^n), devido ao grande número de chamadas recursivas redundantes.
	 * 
	 * Solução Top-Down (Exercício 2 - Fatorial):
	 * A complexidade de tempo é reduzida para O(n) devido ao uso de memoização, que evita recalcular valores já conhecidos.
	 * 
	 * Solução Bottom-Up (Exercício 2 - Fatorial):
	 * A complexidade de tempo também é O(n), pois a abordagem iterativa não envolve
	 * chamadas recursivas e calcula diretamente os resultados necessários.
	 * 
	 * 
	 * A solução feita com programação dinâmica (top-down e bottom-up) é melhor 
	 * do que a solução recursiva porque reduz a redundância de cálculos, armazenando resultados
	 * intermediários em uma tabela (memoização).
	 * Isso leva a uma significativa melhoria no desempenho, especialmente para entradas grandes.
	 * 
	 * A complexidade de tempo O(n) nas soluções dinâmicas significa que o tempo de execução
	 * cresce linearmente com o tamanho da entrada, tornando-as mais eficientes para valores grandes de n em
	 * comparação com a solução recursiva exponencial.
	 * Portanto, a solução feita com programação dinâmica é preferível quando se trata de
	 * otimizar o desempenho para problemas como o cálculo do fatorial.
	 * 
	 */

}
