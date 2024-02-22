package org.example;

public class Calculadora {

    public static int adicionar(int numero1, int numero2){
        return numero1 + numero2;
    }

    public static int subtrair(int numero1, int numero2){
        return numero1 - numero2;
    }

    public static int multiplicar(int numero1, int numero2){
        return numero1 * numero2;
    }

    public static int dividir(int numero1, int numero2){
        if(ehZero(numero1) || ehZero(numero2)){
            return 0;
        }
        return numero1 / numero2;
    }

    private static boolean ehZero(int numero){
        return numero == 0;
    }

}
