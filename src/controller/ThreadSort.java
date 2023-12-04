package controller;


public class ThreadSort extends Thread {
	String tipo;
	int vetor[];
	String interacao;

	public ThreadSort(int vetor[], String tipo, String interacao) {
		this.vetor = vetor;
		this.tipo = tipo;
		this.interacao = interacao;
	}

	@Override
	public void run() {
		if (tipo.equals("quick")) {

			System.out.println("Vetor antes de aplicar o QuickSort " + interacao + ": " + mostravetor());
			long tempoI = System.nanoTime();
			quicksort(vetor, 0, vetor.length - 1);
			long tempoF = System.nanoTime();
			long tempoT = tempoF - tempoI;
			System.out.println("Tempo corrido para o QuickSort " + interacao + ": " + tempoT + " nanossegundos");
			System.out.println("Vetor apos aplicar o QuickSort " + interacao + ": " + mostravetor());

		} else if (tipo.equals("bubble")) {

			System.out.println("Vetor antes de aplicar o BubbleSort " + interacao + ": " + mostravetor());
			long tempoI = System.nanoTime();
			bubblesort(vetor, vetor.length);
			long tempoF = System.nanoTime();
			long tempoT = tempoF - tempoI;
			System.out.println("Tempo corrido para o BubbleSort " + interacao + ": " + tempoT + " nanossegundos");
			System.out.println("Vetor apos aplicar o BubbleSort " + interacao + ": " + mostravetor());
		}
	}

	static void quicksort(int[] vetor, int esquerda, int direita) {
		if (esquerda < direita) {
			int p = particao(vetor, esquerda, direita);
			quicksort(vetor, esquerda, p);
			quicksort(vetor, p + 1, direita);
		}
	}

	static int particao(int[] vetor, int esquerda, int direita) {
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

	private void bubblesort(int[] arr, int tam) {
		
			if (tam == 1)
				return;
			
			for (int i = 0; i < tam - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			bubblesort(arr, tam - 1);

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

