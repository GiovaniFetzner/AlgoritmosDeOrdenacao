import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        File arquivoCSV = new File("Arrays.csv");

        int array128 = 128;
        int array256 = 256;


        if(arquivoCSV.exists()) {

            int[] ordenadoCrescente128 = criarVetorOrdenadoCrescente(array128);
            int[] ordenadoDecrescente128 = criarVetorOrdenadoDecrescente(array128);
            int[] aleatorioSemRepeticao128 = criarVetorAleatorioSemRepeticao(array128);
            int [] aleatorioComRepeticao128 = criarVetoresOrdemAlatoriaComRepeticao(array128);

            //imprimirVetor(aleatorioSemRepeticao);

            cabecalhoCSV("Arrays.csv");
            escreverCSV("Arrays.csv","ordenadoCrescente",array128,ordenadoCrescente128);

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

            for (int i = 0; i < numeros.length; i++) {
                writer.write(String.valueOf(numeros[i]));
                if (i != numeros.length - 1) {
                    writer.write(",");
                }
            }

            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao colocar os dados no arquivo " + nomeArquivo);
            e.printStackTrace();
        }

    }

    private static void cabecalhoCSV (String nomeArquivo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            writer.write("metodo;tamanho;numeros\n");
        } catch (IOException e) {
            System.out.println("Erro ao colocar o cabeçalho no arquivo " + nomeArquivo);
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

    private static int[] dataFormat(String numeros) {
        String[] numerosStringArray = numeros.split(",");

        int[] vetor = new int[numerosStringArray.length];
        for (int i = 0; i < numerosStringArray.length; i++) {
            vetor[i] = Integer.parseInt(numerosStringArray[i]);
        }

        return vetor;
    }


}
