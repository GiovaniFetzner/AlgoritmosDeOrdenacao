import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        File arquivoCSV = new File("Arrays.csv");

        int array128 = 128;

        if(arquivoCSV.exists()) {

            int[] ordenadoCrescente = criarVetorOrdenadoCrescente(array128);
            int[] ordenadoDecrescente = criarVetorOrdenadoDecrescente(array128);
            int[] aleatorioSemRepeticao = criarVetorAleatorioSemRepeticao(array128);
            int [] aleatorioComRepeticao = criarVetoresOrdemAlatoriaComRepeticao(array128);

            imprimirVetor(aleatorioSemRepeticao);

            //cabecalhoCSV("Arrays.csv");
        }else {
            criandoArquivo("Arrays.csv");
        }

    }

    private static int[] criarVetorAleatorioSemRepeticao(int tamanho) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int[] vetor = new int[tamanho];

        // Adiciona todos os números de 1 até tamanho na lista
        for (int i = 1; i <= tamanho; i++) {
            numeros.add(i);
        }

        // Embaralha a lista para garantir ordem aleatória
        Collections.shuffle(numeros);

        // Copia os elementos embaralhados para o vetor
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = numeros.get(i);
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

    private static int[] criarVetoresOrdemAlatoriaComRepeticao (int tamanho){
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(tamanho);
        }
        return vetor;
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

    private static void imprimirVetor(int[] vetor) {
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void escreverCSV (String nomeArquivo,String metodo,int tamanho, int[] numeros){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            writer.write(metodo + ";");
            writer.write(tamanho + ";");
            writer.write("[");
            for (int i = 0; i < numeros.length; i++) {
                writer.write(String.valueOf(numeros[i]));
                if (i != numeros.length - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao colocar os dados no arquivo " + nomeArquivo);
            e.printStackTrace();
        }

    }

    private static void cabecalhoCSV (String nomeArquivo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            writer.write("método;tamanho;números\n");
        } catch (IOException e) {
            System.out.println("Erro ao colocar o cabeçalho no arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }

}
