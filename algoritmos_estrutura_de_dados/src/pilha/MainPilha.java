package pilha;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MainPilha {
	
	private ArrayList<Integer> idades;
	
	public MainPilha() {
		this.idades = new ArrayList<>();
	}
	
	public void push(int idade) {
		this.idades.add(idade);
	}
	
	public int pop() {
		if(!isEmpty()) {
			int poppedObj = this.idades.remove(this.idades.size() - 1);
			return poppedObj;
		} else {
			throw new EmptyStackException();
		}
	}
	
	public int top() {
		if(!isEmpty()) {
			return this.idades.get(this.idades.size() - 1);
		} else {
			throw new EmptyStackException();
		}
	}
	
	public int size() {
		return this.idades.size();
	}

	private boolean isEmpty() {
		return this.idades.isEmpty();
	}
	
	public static void main(String[] args) {
		
		MainPilha mainPilha = new MainPilha();
		
		mainPilha.push(15);
		mainPilha.push(17);
		mainPilha.push(19);
		
		System.out.println("Topo da pilha idade " + mainPilha.top());
		System.out.println("Tamanho da pilha: " + mainPilha.size());
		
		int popIdade = mainPilha.pop();
		System.out.println("Idade removida: " + popIdade);
		System.out.println("Tamanho da pilha após o pop(): " + mainPilha.size());
		
		int topIdade = mainPilha.top();
		System.out.println("Idade retorna: " + topIdade);
		System.out.println("Tamanho da pilha após o top(): " + mainPilha.size());
		
	}

}
