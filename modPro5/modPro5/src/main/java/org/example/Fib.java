package org.example;

public class Fib {

    public static int findElement(int elementNumber){
        if(elementNumber <= 1){
            return elementNumber;
        }
        return findElement(elementNumber - 1) + findElement(elementNumber - 2);
    }
}
