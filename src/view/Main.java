package view;

import java.util.Random;

import controller.ThreadBubble;
import controller.ThreadQuick;

public class Main {

	public static void main(String[] args) {
		int[] vetor50 = gerarVetor(50);
		int[] vetor1000 = gerarVetor(1000);
		int[] vetor10000 = gerarVetor(10000);

		ThreadQuick quick1 = new ThreadQuick(vetor50, "1");
		ThreadBubble bubble1 = new ThreadBubble(vetor50, "1");
		quick1.start();
		bubble1.start();

		ThreadQuick quick2 = new ThreadQuick(vetor1000, "2");
		ThreadBubble bubble2 = new ThreadBubble(vetor1000, "2");
		quick2.start();
		bubble2.start();
		ThreadQuick quick3 = new ThreadQuick(vetor10000, "3");
		ThreadBubble bubble3 = new ThreadBubble(vetor10000, "3");

//Caso apareça no console apenas os valores relacionados a interação 3, tirar a limitação de output do console nas configurações de RUN/DEBUG

		quick3.start();
		bubble3.start();
	}

	public static int[] gerarVetor(int tam) {
		int[] array = new int[tam];
		Random random = new Random();

		for (int i = 0; i < tam; i++) {
			array[i] = random.nextInt(1000) + 1;
		}

		return array;
	}

}
