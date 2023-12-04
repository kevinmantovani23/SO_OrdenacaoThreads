package controller;

public class ThreadBubble extends Thread {

	int vetor[];
	String interacao;

	public ThreadBubble(int vetor[], String interacao) {
		this.vetor = vetor;
		this.interacao = interacao;
	}

	@Override
	public void run() {
		System.out.println("Vetor antes de aplicar o BubbleSort " + interacao + ": " + mostravetor());
		long tempoI = System.nanoTime();
		bubblesort(vetor, vetor.length);
		long tempoF = System.nanoTime();
		long tempoT = tempoF - tempoI;
		System.out.println("Tempo corrido para o BubbleSort " + interacao + ": " + tempoT + " nanossegundos");
		System.out.println("Vetor apos aplicar o BubbleSort " + interacao + ": " + mostravetor());
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
