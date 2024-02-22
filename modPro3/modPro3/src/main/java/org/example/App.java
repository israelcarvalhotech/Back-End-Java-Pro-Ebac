package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Backtracking backtracking = new Backtracking();
        List<Integer> listaInteiros = List.of(1,2,3,4);
        int X = 3;
        List<List<Integer>> resultado = backtracking.gerarCombinacoes(listaInteiros, X);

        for (List<Integer> combinacao : resultado) {
            System.out.println(combinacao);
        }

        AlgoritmoGuloso algoritmoGuloso = new AlgoritmoGuloso();
        System.out.println(algoritmoGuloso.calcularTroco(18));
    }
}
