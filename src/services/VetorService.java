package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VetorService {
    public static int[] criarVetorOrdenadoCrescente(int tamanho) {
        int[] vetorOrdenado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorOrdenado[i] = i;
        }
        return vetorOrdenado;
    }

    public static int[] criarVetorOrdenadoDecrescente(int tamanho) {
        int[] vetorOrdenado = new int[tamanho];
        int j = 0;

        for (int i = tamanho; i > 0; i--) {
            vetorOrdenado[j] = i;
            j++;
        }
        return vetorOrdenado;
    }

    public static int[] criarVetoresOrdemAlatoriaComRepeticao(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho);
        }
        return vetor;
    }

    public static int[] criarVetorAleatorioSemRepeticao(int tamanho) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int[] vetor = new int[tamanho];

        for (int i = 1; i <= tamanho; i++) {
            numeros.add(i);
        }

        Collections.shuffle(numeros);

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = numeros.get(i);
        }

        return vetor;
    }


    public static void imprimirVetor(int[] vetor) {
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void ordenacaoBubbleSort(int[] vetorDesordenado){
        for (int i = 0; i < vetorDesordenado.length; i++){
            for (int j = 0; j < (vetorDesordenado.length - 1); j++){
                if(vetorDesordenado[j] > vetorDesordenado[j +1]){
                    int temp = vetorDesordenado[j + 1];
                    vetorDesordenado[j + 1] = vetorDesordenado[j];
                    vetorDesordenado[j] = temp;
                }
            }
        }
    }

    public static void ordenacaoInsertionSort(int[] vetorDesordenado){
        for(int i = 0; i < (vetorDesordenado.length - 1); i++){
            if(vetorDesordenado[i] > vetorDesordenado[i + 1]){
                int temp = vetorDesordenado[i];
                vetorDesordenado[i] = vetorDesordenado[i + 1];
                vetorDesordenado[i + 1] = temp;

                for (int j = i; j > 0 ; j--){
                    if(vetorDesordenado[j] < vetorDesordenado[j - 1]){
                        int temp2 = vetorDesordenado[j];
                        vetorDesordenado[j] = vetorDesordenado[j - 1];
                        vetorDesordenado[j - 1] = temp2;
                    }
                }
            }
        }
    }
    public static void ordenacaoSelectionSort(int[] vetorDesordenado){
        for(int i = 0; i < vetorDesordenado.length; i++){
            int minTerm = vetorDesordenado[i];
            int indexMinTerm = i;
            for (int j = i; j < vetorDesordenado.length; j++){
                if(minTerm > vetorDesordenado[j]){
                    indexMinTerm = j;
                    minTerm = vetorDesordenado[j];
                }

            }
            vetorDesordenado[indexMinTerm] = vetorDesordenado[i];
            vetorDesordenado[i] = minTerm;
        }
    }

    public static void ordenacaoHeapShort (int[] vetorDesordenado){
        int n = vetorDesordenado.length;
        for (int i = n / 2 - 1;i >=0; i--){
            heapify(vetorDesordenado,n,i);
        }
        for(int i = n -1; i > 0; i--){
            int temp = vetorDesordenado[0];
            vetorDesordenado[0] = vetorDesordenado[i];
            vetorDesordenado[i] = temp;

            heapify(vetorDesordenado, i, 0);
        }
    }

    static void heapify(int [] vetor, int n, int i){
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }
        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }
        if (maior != i){
            int swap = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = swap;

            heapify(vetor,n,maior);
        }
    }

    public static void ordenacaoShellSort(int[] vetorDesordenado){
        int n = vetorDesordenado.length;

        for (int gap = n / 2; gap > 0; gap /= 2){
            for(int i = gap; i < n; i++){
                int temp = vetorDesordenado[i];
                int j;
                for(j = i; j >= gap && vetorDesordenado[j - gap] > temp; j -= gap){
                    vetorDesordenado[j] = vetorDesordenado[j - gap];
                }
                vetorDesordenado[j] = temp;
            }
        }
    }

}
