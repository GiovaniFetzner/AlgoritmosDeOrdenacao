import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

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

        /*int array128 = 128;
        int array256 = 256;


        if(arquivoCSV.exists()) {

            int[] ordenadoCrescente128 = VetorService.criarVetorOrdenadoCrescente(array128);
            int[] ordenadoDecrescente128 = VetorService.criarVetorOrdenadoDecrescente(array128);
            int[] aleatorioSemRepeticao128 = VetorService.criarVetorAleatorioSemRepeticao(array128);
            int [] aleatorioComRepeticao128 = VetorService.criarVetoresOrdemAlatoriaComRepeticao(array128);

            //imprimirVetor(aleatorioSemRepeticao);

            ArquivoService.cabecalhoCSV("Arrays.csv");
            ArquivoService.escreverCSV("Arrays.csv","ordenadoCrescente",array128,ordenadoCrescente128);

        }else {
            ArquivoService.criandoArquivo("Arrays.csv");
        }*/


    }



}
