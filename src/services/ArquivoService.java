package services;

import java.io.*;

public class ArquivoService {

    public static void criandoArquivo(String nomeArquivo) {
        File novoArquivoCSV = new File(nomeArquivo);
        try {
            novoArquivoCSV.createNewFile();
            cabecalhoCSV(novoArquivoCSV);
        } catch (IOException e) {
            System.out.println("\nFalha ao criar arquivo!");
            e.printStackTrace();
        }
        System.out.println("\nArquivo criado!");
    }
    public static void escreverCSV (File arquivo,String metodo, int[] numeros){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))){
            writer.write(metodo + ";");
            writer.write(numeros.length + ";");

            for (int i = 0; i < numeros.length; i++) {
                writer.write(String.valueOf(numeros[i]));
                if (i != numeros.length - 1) {
                    writer.write(",");
                }
            }

            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao colocar os dados no arquivo " + arquivo.getName());
            e.printStackTrace();
        }

    }
    private static void cabecalhoCSV (File arquivo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))){
            writer.write("metodo;tamanho;numeros\n");
        } catch (IOException e) {
            System.out.println("Erro ao colocar o cabeçalho no arquivo " + arquivo.getName());
            e.printStackTrace();
        }
    }

    public static int[] lerVetor(File arquivo, String metodo, int tamanho){
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha = reader.readLine();

            while((linha = reader.readLine()) != null){
                String[] colunas = linha.split(";");

                String metodoCSV = colunas[0];
                String tamanhoCSV = colunas[1];
                String numerosCSV = colunas[2];
                if (metodoCSV.equals(metodo) && Integer.parseInt(tamanhoCSV) == tamanho ) {
                    return dataFormat(numerosCSV);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo, fvor conferir parametros do metodo");
            throw new RuntimeException(e);
        }

        return null;
    }

    private static int[] dataFormat(String numeros) {
        String[] numerosString = numeros.split(",");

        int[] vetor = new int[numerosString.length];
        for (int i = 0; i < numerosString.length; i++) {
            vetor[i] = Integer.parseInt(numerosString[i].trim());
        }
        return vetor;
    }



}
