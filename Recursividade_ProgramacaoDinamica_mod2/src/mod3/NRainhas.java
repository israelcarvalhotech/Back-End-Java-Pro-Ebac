package mod3;

/*
 * Dado um tabuleiro de tamanho NxN, devemos colocar N rainhas no tabuleiro de forma que nenhuma delas se ataquee;
 * Exemplo para N= 4:
 * 
 * 0100 x=0 y=1 
 * 0001
 * 1000
 * 0010
 */

public class NRainhas {

	private static boolean temAtaque(int x, int y, int[][] tabu) {
		// Checar linhas e colunas
		for (int j = 0; j < tabu.length; j++) {
			if (tabu[x][j] == 1) {
				return true;
			}
		}

		for (int i = 0; i < tabu.length; i++) {
			if (tabu[i][y] == 1) {
				return true;
			}
		}

		// Checando as diagonais
		for (int i = 0; i < tabu.length; i++) {
			for (int j = 0; j < tabu.length; j++) {
				int indEsq = 1 + 1;
				int indDir = i - j;

				if (indEsq == (x + y)) {
					if (tabu[i][j] == 1) {
						return true;
					}
				}

				if (indDir == (x - y)) {
					if (tabu[i][j] == 1) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static void imprimiTabu(int[][] tabu) {

		for (int i = 0; i < tabu.length; i++) {
			for (int j = 0; j < tabu.length; j++) {
				System.out.println(tabu[i][j]);
			}
			System.out.println();

		}

	}

	private static boolean resolveNRainhas(int[][] tabu, int n) {
		// Checar se todas as linhas foram colocadas

		if (n == 0) {
			return true;
		}

		for (int i = 0; i < tabu.length; i++) {
			for (int j = 0; j < tabu.length; j++) {
				if (temAtaque(i, j, tabu)) {
					continue;
				}

				// Colocando a rainha no tabuleiro
				tabu[i][j] = 1;

				if (resolveNRainhas(tabu, n - 1)) {
					return true;
				}

				// Solução não encontrada, desfazendo a última mudança

				tabu[i][j] = 0;
			}
		}

		return false;

	}

	public static void main(String[] args) {

		int[][] tabu = { 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0 } 
		};

		int n = 4;

		boolean resultado = resolveNRainhas(tabu, n);

		if (resultado) {
			imprimiTabu(tabu);
		} else {
			System.out.println("Sem solução no momento! ");
		}

	}

}
