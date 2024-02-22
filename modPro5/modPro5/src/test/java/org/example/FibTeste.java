package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibTeste {

    @Test
    public void testFindElement_HappyPath(){
        //System.out.println(Fib.findElement(5));
        int result = Fib.findElement(7);
        assertEquals(result, 13);
    }
}
