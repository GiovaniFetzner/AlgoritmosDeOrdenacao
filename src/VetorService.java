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

    public static int[] ordenacaoBublleShort(int[] vetorDesordenado){
        for (int i = 0; i < vetorDesordenado.length; i++){
            for (int j = 0; j < (vetorDesordenado.length - 1); j++){
                if(vetorDesordenado[j] > vetorDesordenado[j +1]){
                    int temp = vetorDesordenado[j + 1];
                    vetorDesordenado[j + 1] = vetorDesordenado[j];
                    vetorDesordenado[j] = temp;
                }
            }
        }
        return null;
    }


}
