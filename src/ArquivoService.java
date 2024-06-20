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

    private static int[] dataFormat(String numeros) {
        String[] numerosStringArray = numeros.split(",");

        int[] vetor = new int[numerosStringArray.length];
        for (int i = 0; i < numerosStringArray.length; i++) {
            vetor[i] = Integer.parseInt(numerosStringArray[i]);
        }

        return vetor;
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

    private static int[] getVetor(File nomeArquivo){
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = reader.readLine();
            String[] cabecalhos = linha.split(";");

            while((linha = reader.readLine()) != null){
                String[] colunas = linha.split(";");

                String metodo = colunas[0];
                String tamanho = colunas[1];
                String numeros = colunas[2];

                dataFormat(numeros);
            }

            int[] vetor;

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;

    }
}
