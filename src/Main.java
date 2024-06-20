import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 65536};
        int[] tamanhos = {128};

        String[] cenariosDeTeste = {"VetorOrdenadoCrescente", "VetorOrdenadoDecrescente",
                "VetorAleatorioSemRepeticao", "VetoresOrdemAlatoriaComRepeticao"};

        AlgoritmoOrdenacao algoritmo = VetorService::ordenacaoBublleSort;

        // Loop de aquecimento
        for (int i = 0; i < 100; i++) {
            int[] vetorDeAquecimento = new int[]{5, 5, 4, 2, 1, 8};
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
            VetorService.ordenacaoBublleSort(vetorDeAquecimento);
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
        }


        for (int tamanho : tamanhos) {
            long[] registrosDeTempo = new long[10];

            for (int i = 0; i < registrosDeTempo.length; i++) {
                int[] vetorDeTeste = ArquivoService.lerVetor(new File("Arrays.csv"),
                        "VetoresOrdemAlatoriaComRepeticao", tamanho);
                long startTime = System.nanoTime();
                algoritmo.ordenar(vetorDeTeste);
                long endTime = System.nanoTime();
                registrosDeTempo[i] = (endTime - startTime);
                System.out.println(registrosDeTempo[i]);
                double tempoExecucaoSegundos = registrosDeTempo[i] / 1_000_000_000.0;

               imprimeTempo(tempoExecucaoSegundos);

            }

            long mediaTempo = Arrays.stream(registrosDeTempo).reduce(0, Long::sum) / registrosDeTempo.length;
            double mediaTempoSegundos = mediaTempo / 1_000_000_000.0;
            imprimeTempo(mediaTempoSegundos);

        }
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
        String[] cenariosDeTeste = {"VetorOrdenadoCrescente", "VetorOrdenadoDecrescente",
                "VetorAleatorioSemRepeticao", "VetoresOrdemAlatoriaComRepeticao"};

        for(int i = 0; i < tamanhos.length; i++){
            for (int j = 0; j < cenariosDeTeste.length; j++) {
                VetorService.imprimirVetor(ArquivoService.lerVetor(arquivoCSV, cenariosDeTeste[j], tamanhos[i]));
            }
        }
    }

    private static void imprimeTempo(double tempoExecucaoSegundos) {
        if (tempoExecucaoSegundos >= 1) {
            System.out.printf("Tempo de execução: %.2f segundos.%n", tempoExecucaoSegundos);
        } else if (tempoExecucaoSegundos >= 0.001) {
            System.out.printf("Tempo de execução: %.2f milissegundos.%n", (tempoExecucaoSegundos * 1_000));
        } else if (tempoExecucaoSegundos >= 0.000001) {
            System.out.printf("Tempo de execução: %.2f microssegundos.%n", (tempoExecucaoSegundos * 1_000_000));
        } else {
            System.out.printf("Tempo de execução: %.2f nanossegundos.%n", (tempoExecucaoSegundos * 1_000_000_000));
        }
    }

}
