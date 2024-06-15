import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        File arquivoCSV = new File("Arrays.csv");

        if(arquivoCSV.exists()) {
            System.out.println("criarVetorOrdenadoCrescente");
            int[] ordenadoCrescente = criarVetorOrdenadoCrescente(128);
            System.out.println("\ncriarVetorOrdenadoDecrescente");
            int[] ordenadoDecrescente = criarVetorOrdenadoDecrescente(128);
            System.out.println("\ncriarVetorAleatorioSemRepeticao");
            int[] aleatorioSemRepeticao = criarVetorAleatorioSemRepeticao(15);
            System.out.println(aleatorioSemRepeticao);
        }else {
            criandoArquivo("Arrays.csv");
        }

    }

    private static int[] criarVetorAleatorioSemRepeticao(int tamanho) {
        HashSet<Integer> numeros = new HashSet<>();
        int[] vetor = new int[tamanho];

        while(numeros.size() < tamanho) {
            numeros.add((int)(Math.random() * tamanho));
        }

        int index = 0;
        for (int numero : numeros) {
            vetor[index++] = numero;
        }

        return vetor;
    }

    private static int[] criarVetorOrdenadoCrescente(int tamanho) {
        int[] vetorOrdenado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorOrdenado[i] = i;
        }
        return vetorOrdenado;
    }

    private static int[] criarVetorOrdenadoDecrescente(int tamanho) {
        int[] vetorOrdenado = new int[tamanho];
        int j = 0;

        for (int i = tamanho; i > 0; i--) {
            vetorOrdenado[j] = i;
            j++;
        }
        return vetorOrdenado;
    }

    public static void criandoArquivo(String nomeArquivo) {
        File novoArquivoCSV = new File(nomeArquivo);
        try {
            novoArquivoCSV.createNewFile();
        } catch (IOException e) {
            System.out.println("\nFalha ao criar arquivo!");
            e.printStackTrace();
        }
        System.out.println("\nArquivo criado!");
    }

}
