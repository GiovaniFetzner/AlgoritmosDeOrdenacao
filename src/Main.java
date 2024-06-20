import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 65536};

        //int[] vetorDeTeste = ArquivoService.lerVetor(new File("Arrays.csv"),"VetoresOrdemAlatoriaComRepeticao",128);

        long[] registros = new long[10];

        // Loop de aquecimento
        for (int i = 0; i < 10; i++) {
            int[] vetorDeAquecimento = new int[]{5, 5, 4, 2, 1, 8};
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
            VetorService.ordenacaoBublleSort(vetorDeAquecimento);
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
        }

        for (int i = 0; i < registros.length; i++) {
            int[] vetorDeTeste = ArquivoService.lerVetor
                    (new File("Arrays.csv"),"VetoresOrdemAlatoriaComRepeticao",128);
            long startTime = System.nanoTime();
            VetorService.ordenacaoBublleSort(vetorDeTeste);
            long endTime = System.nanoTime();
            registros[i] = (endTime - startTime);
        }
        for (long duracao: registros) {
            System.out.print(duracao + " ");
        }
        System.out.println("\nMedia de tempo para a execucao 128: " +
                (Arrays.stream(registros).reduce(0,Long::sum)/registros.length) + " nanosegundos");
    }

    private static void criarCasosDeTeste() {
        File arquivoCSV = new File("Arrays.csv");

        if (!arquivoCSV.exists()) {
            ArquivoService.criandoArquivo("Arrays.csv");
        }
        int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 65536};

        for (int tamanho:tamanhos) {
            ArquivoService.escreverCSV(arquivoCSV, "VetorOrdenadoCrescente",
                    VetorService.criarVetorOrdenadoCrescente(tamanho));

            ArquivoService.escreverCSV(arquivoCSV, "VetorOrdenadoDecrescente",
                    VetorService.criarVetorOrdenadoDecrescente(tamanho));

            ArquivoService.escreverCSV(arquivoCSV, "VetorAleatorioSemRepeticao",
                    VetorService.criarVetorAleatorioSemRepeticao(tamanho));

            ArquivoService.escreverCSV(arquivoCSV, "VetoresOrdemAlatoriaComRepeticao",
                    VetorService.criarVetoresOrdemAlatoriaComRepeticao(tamanho));

            System.out.println("Vetores de tamanho " + tamanho + " gerados e gravados no arquivo csv!");
        }
    }

    private static void lerCasosDeTeste(String nomeArquivo){
        File arquivoCSV = new File(nomeArquivo);

        if (!arquivoCSV.exists()){
            System.out.println("Arquivo nao encontrado!! Favor conferir existencia do arquivo ");
            return;
        }

        int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 65536};
        String[] metodos = {"VetorOrdenadoCrescente", "VetorOrdenadoDecrescente",
                "VetorAleatorioSemRepeticao", "VetoresOrdemAlatoriaComRepeticao"};

        for(int i = 0; i < tamanhos.length; i++){
            for (int j = 0; j < metodos.length; j++) {
                VetorService.imprimirVetor(ArquivoService.lerVetor(arquivoCSV, metodos[j], tamanhos[i]));
            }
        }
    }

}
