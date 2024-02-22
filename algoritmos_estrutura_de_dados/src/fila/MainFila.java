package fila;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MainFila {

	private Queue<Integer> years;
	
	public MainFila() {
		this.years = new LinkedList<>();
	}
	
	public void enqueue(int years) {
		this.years.add(years);
	}
	
	public int dequeue() {
		if(!isEmpty()) {
			return this.years.poll();
		} else {
			throw new NoSuchElementException("Fila de 'years' vazia, não possível realizar dequeue! ");
		}
	}
	
	public int rear() {
		if (!isEmpty()) {
			return ((LinkedList<Integer>) this.years).getLast();
		} else {
			throw new NoSuchElementException("Fila 'years' vazia, não possui elementos no final! ");
		}
	}
	
	public int front() {
        if (!isEmpty()) {
            return this.years.peek();
        } else {
            throw new NoSuchElementException("A fila 'years' está vazia. Não há elemento na frente.");
        }
    }
	
	public int size() {
        return this.years.size();
    }

	private boolean isEmpty() {
		return this.years.isEmpty();
	}

	public static void main(String[] args) {
		
		MainFila mainFila = new MainFila();
		
		mainFila.enqueue(2004);
		mainFila.enqueue(2008);
		mainFila.enqueue(2020);
		
		System.out.println("Frente da fila: " + mainFila.front());
        System.out.println("Final da fila: " + mainFila.rear());
        System.out.println("Tamanho da fila: " + mainFila.size());

        int itemRemovido = mainFila.dequeue();
        System.out.println("Item removido: " + itemRemovido);
        System.out.println("Tamanho da fila após dequeue: " + mainFila.size());
        
        Boolean vazio = mainFila.isEmpty();
        System.out.println("A lista está vazia? " + vazio);
	
	}
	
	
}
