package main;

import services.ArquivoService;
import services.VetorService;

import java.io.*;
import java.util.*;

public class Main {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED_BOLD = "\u001B[31;1m";

    public static void main(String[] args) {

        int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 65536};

        String[] cenariosDeTeste = {"VetorOrdenadoCrescente", "VetorOrdenadoDecrescente",
                "VetorAleatorioSemRepeticao", "VetoresOrdemAlatoriaComRepeticao"};

        /*
        * Escolher cenario de teste e metodo de ordenacao:
        */
        String cenarioDeTesteEscolhido = "VetoresOrdemAlatoriaComRepeticao";
        AlgoritmoOrdenacao algoritmo = VetorService::ordenacaoMegaSort;

        // Loop de aquecimento
        for (int i = 0; i < 1; i++) {
            int[] vetorDeAquecimento = new int[]{5, 5, 4, 2, 1, 8, 3, 0};
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
            algoritmo.ordenar(vetorDeAquecimento);
            if (i == 0) VetorService.imprimirVetor(vetorDeAquecimento);
        }

        System.out.println("Cenario de teste escolhido " + ANSI_GREEN+ cenarioDeTesteEscolhido + ANSI_RESET);
        for (int tamanho : tamanhos) {
            long[] registrosDeTempo = new long[10];

            for (int i = 0; i < registrosDeTempo.length; i++) {
                int[] vetorDeTeste = ArquivoService.lerVetor(new File("Arrays.csv"),
                        cenarioDeTesteEscolhido, tamanho);
                long startTime = System.nanoTime();
                algoritmo.ordenar(vetorDeTeste);
                long endTime = System.nanoTime();
                registrosDeTempo[i] = (endTime - startTime);
            }

            long mediaTempo = Arrays.stream(registrosDeTempo).reduce(0, Long::sum) / registrosDeTempo.length;
            double mediaTempoSegundos = mediaTempo / 1_000_000_000.0;

            System.out.println("Vetor de tamanho, " + ANSI_GREEN + tamanho + ANSI_RESET +
                    ", possui o seguinte tempo para executar 10 ordenacoes: " +
                    ANSI_RED_BOLD + mediaTempoSegundos + ANSI_RESET + " segundos");



            imprimeTempo(calculoMediaEmSegundos(registrosDeTempo));
        }


    }

    private static double calculoMediaEmSegundos(long[] registrosDeTempo){
        long mediaTempo = Arrays.stream(registrosDeTempo).reduce(0, Long::sum) / registrosDeTempo.length;
        return mediaTempo/ 1_000_000_000.0;
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
