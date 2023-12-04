package controller;

public class ThreadQuick extends Thread{
	int vetor[];
	String interacao;

	public ThreadQuick(int vetor[], String interacao) {
		this.vetor = vetor;
		this.interacao = interacao;
	}

	@Override
	public void run() {
		
		System.out.println("Vetor antes de aplicar o QuickSort " + interacao + ": " + mostravetor());
		long tempoI = System.nanoTime();
		quicksort(vetor, 0, vetor.length - 1);
		long tempoF = System.nanoTime();
		long tempoT = tempoF - tempoI;
		System.out.println("Tempo corrido para o QuickSort " + interacao + ": " + tempoT + " nanossegundos");
		System.out.println("Vetor apos aplicar o QuickSort " + interacao + ": " + mostravetor());
	}

	private void quicksort(int[] vetor, int esquerda, int direita) {
		if (esquerda < direita) {
			int p = particao(vetor, esquerda, direita);
			quicksort(vetor, esquerda, p);
			quicksort(vetor, p + 1, direita);
		}
	}

	private int particao(int[] vetor, int esquerda, int direita) {
		int meio = (int) (esquerda + direita) / 2;
		int pivo = vetor[meio];
		int i = esquerda - 1;
		int j = direita + 1;
		while (true) {
			do {
				i++;
			} while (vetor[i] < pivo);
			do {
				j--;
			} while (vetor[j] > pivo);
			if (i >= j) {
				return j;
			}
			int aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
		}
	}

	private String mostravetor() {
		StringBuffer vetStr = new StringBuffer();
		vetStr.append("[");
		for (int i : vetor) {
			vetStr.append(i + " ");
		}
		vetStr.append("]");
		return vetStr.toString();
	}
}

