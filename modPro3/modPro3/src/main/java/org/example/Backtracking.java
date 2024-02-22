package org.example;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static List<List<Integer>> gerarCombinacoes(List<Integer> lista, int X) {
        List<List<Integer>> resultado = new ArrayList<>();
        gerarCombinacoesRecursivas(lista, X, resultado, new ArrayList<>(), 0);
        return resultado;
    }

    private static void gerarCombinacoesRecursivas(List<Integer> lista, int X, List<List<Integer>> resultado, List<Integer> atual, int indice) {
        if (atual.size() == X) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        for (int i = indice; i < lista.size(); i++) {
            atual.add(lista.get(i));

            gerarCombinacoesRecursivas(lista, X, resultado, atual, i + 1);

            atual.remove(atual.size() - 1);
        }
    }
}
