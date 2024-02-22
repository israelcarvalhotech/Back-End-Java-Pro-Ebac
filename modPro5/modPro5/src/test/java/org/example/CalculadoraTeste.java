package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTeste {

    @Test
    public void testeAdicionar_HappyPath(){
        int resultado = Calculadora.adicionar(2,3);
        assertEquals(resultado, 5);
    }

    @Test
    public void testeSubtrair_HappyPath(){
        int resultado = Calculadora.subtrair(2,3);
        assertEquals(resultado, -1);
    }

    @Test
    public void testeMultiplicar_HappyPath(){
        int resultado = Calculadora.multiplicar(2,3);
        assertEquals(resultado, 6);
    }

    @Test
    public void testeDividir_HappyPath(){
        int resultado = Calculadora.dividir(8,4);
        assertEquals(resultado, 2);
    }

    @Test
    public void testeDividir_eHZero(){
        int resultado = Calculadora.dividir(0,3);
        assertEquals(resultado, 0);
    }

}
