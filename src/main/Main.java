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
        AlgoritmoOrdenacao algoritmo = VetorService::ordenacaoBubbleSort;

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


            System.out.println("Tempo medio de execução: " + formatTempo(calculoMediaEmSegundos(registrosDeTempo)));

            double variancia = calculoVariancia(registrosDeTempo, calculoMediaEmNanosegundos(registrosDeTempo));

            System.out.println("Variancia: " + variancia);
            System.out.println("Desvio padrao: " + calculoDesvioPadrao(variancia));

            ArrayList<Long> intervalo = calculaIntervalo(registrosDeTempo,
                    calculoMediaEmNanosegundos(registrosDeTempo), calculoDesvioPadrao(variancia));

            System.out.println("Valores dentro do intervalo: " + intervalo);

            long mediaIntervalo = intervalo.stream().mapToLong(Long::longValue).sum()/ intervalo.size();
            double mediaIntervaloSegundos = mediaIntervalo / 1_000_000_000.0;

            System.out.println("Media somente dos valores dentro do intervalo: " + ANSI_RED_BOLD +
                    formatTempo(mediaIntervaloSegundos) + ANSI_RESET);
            System.out.println();

        }


    }

    private static double calculoMediaEmSegundos(long[] registrosDeTempo){
        long mediaTempo = Arrays.stream(registrosDeTempo).reduce(0, Long::sum) / registrosDeTempo.length;
        return mediaTempo/ 1_000_000_000.0;
    }

    private static long calculoMediaEmNanosegundos(long[] registrosDeTempo){
        return Arrays.stream(registrosDeTempo).reduce(0, Long::sum) / registrosDeTempo.length;
    }

    private static double calculoVariancia(long[] registrosDeTempo, double mediaEmNanossegundos){
        double sum = 0;
        for (long tempoRegistrado:registrosDeTempo) {
            sum += Math.pow((tempoRegistrado - mediaEmNanossegundos),2);
        };
        sum = (sum/9);
        return sum;
    }

    private static double calculoDesvioPadrao(double variancia){
        return Math.sqrt(variancia);
    }

    private static ArrayList<Long> calculaIntervalo(long[] registrosDeTempo,long mediaEmNano, double desvioPadrao){
        ArrayList<Long> intervalo = new ArrayList<>();
        long inicioIntervalo = (long) (mediaEmNano - desvioPadrao);
        long finalDoIntervalo = (long) (mediaEmNano + desvioPadrao);

        for (long tempoRegistrado:registrosDeTempo) {
            if (tempoRegistrado > inicioIntervalo && tempoRegistrado < finalDoIntervalo){
                intervalo.add(tempoRegistrado);
            }
        }

        return intervalo;
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

    private static String formatTempo(double tempoExecucaoSegundos) {
        if (tempoExecucaoSegundos >= 1) {
            return String.format("%.2f segundos.", tempoExecucaoSegundos);
        } else if (tempoExecucaoSegundos >= 0.001) {
            return String.format("%.2f milissegundos.", (tempoExecucaoSegundos * 1_000));
        } else if (tempoExecucaoSegundos >= 0.000001) {
            return String.format("%.2f microssegundos.", (tempoExecucaoSegundos * 1_000_000));
        } else {
            return String.format("%.2f nanossegundos.", (tempoExecucaoSegundos * 1_000_000_000));
        }
    }

}
