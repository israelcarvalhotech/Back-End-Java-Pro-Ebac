package listaEncadeada;

public class MainListaEncadeada {

	private Node head;

	public MainListaEncadeada() {
		this.head = null;
	}

	// Adiciona um nó ao fim da lista
	public void push(Node node) {
		if (head == null) {
			head = node;
			return;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
	}

	// Remove o nó no fim da lista e retorna o mesmo
	public Node pop() {
		if (head == null) {
			return null;
		}
		
		if (head.next == null) {
			Node removeNode = head;
			head = null;
			return removeNode;
		}

		Node secondLast = head;
		while (secondLast.next.next != null) {
			secondLast = secondLast.next;
		}

		Node removedNode = secondLast.next;
		secondLast.next = null;
		return removedNode;
	}

	// Adiciona um nó na posição indicada
	public void insert(int index, Node node) {
		if (index < 0) {
			System.out.println("Índice inválido para inserção! ");
			return;
		}
		if (index == 0) {
			node.next = head;
			head = node;
			return;
		}

		Node current = head;
		for (int i = 0; i < index - 1 && current != null; i++) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("Índice inválido para inserção.");
			return;
		}
		node.next = current.next;
		current.next = node;
	}

	// Remove o nó na posição indicada
	public void remove(int index) {
		if (index < 0) {
			System.out.println("Índice inválido para remoção.");
			return;
		}
		if (index == 0 && head != null) {
			head = head.next;
			return;
		}

		Node current = head;
		for (int i = 0; i < index - 1 && current != null; i++) {
			current = current.next;
		}

		if (current == null || current.next == null) {
			System.out.println("Índice inválido para remoção.");
			return;
		}

		current.next = current.next.next;

	}

	// Retorna o elemento no índice indicado
	public Node elementAt(int index) {
		Node current = head;
		for (int i = 0; i < index && current != null; i++) {
			current = current.next;
		}

		return current;
	}

	// Retorna o tamanho da lista
	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	// Retorna uma representação em texto da lista
	public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

	public static void main(String[] args) {
		MainListaEncadeada lista = new MainListaEncadeada();
		
		Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        lista.push(node1);
        lista.push(node2);
        lista.push(node3);
     
        System.out.println("Lista Encadeada: ");
        lista.printList();
	    
        System.out.println("Removendo o último elemento:");
        Node removedNode = lista.pop();
        System.out.println("Elemento removido: " + removedNode.data);

        System.out.println("Inserindo um novo elemento no índice 1:");
        Node newNode = new Node(4);
        lista.insert(1, newNode);

        System.out.println("Lista após a inserção:");
        lista.printList();

        System.out.println("Removendo o elemento no índice 1:");
        lista.remove(1);

        System.out.println("Lista após a remoção:");
        lista.printList();
    }
	
}
