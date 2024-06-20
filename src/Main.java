import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        lerCasosDeTeste("Arrays.csv");

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


    }

}
