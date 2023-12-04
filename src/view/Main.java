package view;

import java.util.Random;

import controller.ThreadSort;

public class Main {

	public static void main(String[] args) {
		int [] vetor50 = gerarVetor(50);
		int [] vetor1000 = gerarVetor(1000);
		int [] vetor10000 = gerarVetor(10000);
		
		ThreadSort quick1 = new ThreadSort(vetor50, "quick", "1");
		ThreadSort bubble1 = new ThreadSort(vetor50, "bubble", "1");
		quick1.start();
		bubble1.start();
		
		ThreadSort quick2 = new ThreadSort(vetor1000, "quick", "2");
		ThreadSort bubble2 = new ThreadSort(vetor1000, "bubble", "2");
		quick2.start();
		bubble2.start();
		ThreadSort quick3 = new ThreadSort(vetor10000, "quick", "3");
		ThreadSort bubble3 = new ThreadSort(vetor10000, "bubble", "3"); 
		
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

