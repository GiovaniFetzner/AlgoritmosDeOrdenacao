# Trabalho sobre algoritmos de ordenação

## Introdução

Este projeto tem como objetivo realizar testes de desempenho para diferentes métodos de ordenação. 
Os testes serão conduzidos em vetores de diversos tamanhos e em quatro cenários distintos:

1. Vetor ordenado em ordem crescente, sem valores repetidos;
2. Vetor ordenado em ordem decrescente, sem valores repetidos;
3. Vetor aleatório sem valores repetidos; e
4. Vetor aleatório com valores repetidos.

Para cada teste, deve-se utilizar o mesmo vetor e medir o tempo de execução em cada um dos cenários descritos acima.

Foi adotado o método de armazenamento em arquivo para facilitar a manipulação dos vetores. Para criá-los, foram utilizadas as classes ArquivoService e VetorService. Após a criação e organização dos vetores, os dados foram armazenados em um arquivo no formato CSV.

Para realizar os testes, é necessário acessar o arquivo, ler o vetor e selecionar o tipo de ordenação que será utilizado. Após essas escolhas, o vetor selecionado será ordenado e será impresso os detalhes sobre sua execução.

> **Observação:**
>
> Note que o tempo médio registrado nas tabelas abaixo refere-se ao tempo médio que está dentro do intervalo permitido pelo descritivo do trabalho. Ou seja, de acordo com o tempo das dez execuções para cada cenário, é obtido o tempo médio, e posteriormente, a variância e o desvio padrão. Para encontrar o intervalo de tempo válido para as execuções, foi utilizado um desvio padrão de tolerância.


#### Tabela 1. Tempos computados para Vetor ordenado em ordem crescente e sem valores repetidos 

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |   89,63 µs   |     4,42 µs    |    152,81 µs   |   20,64 µs  |   30,96 µs  |             |             |
| 256                  |   94,36 µs   |     4,90 µs    |    151,80 µs   |   24,41 µs  |   69,40 µs  |             |             |
| 512                  |   96,54 µs   |    14,43 µs    |     59,66 µs   |   71,50 µs  |  150,67 µs  |             |             |
| 1024                 |  356,76 µs   |    25,80 µs    |    177,22 µs   |  139,00 µs  |   52,68 µs  |             |             |
| 2048                 |    1,29 ms   |    50,16 µs    |    695,41 µs   |  293,41 µs  |   67,78 µs  |             |             |
| 4096                 |    3,14 ms   |    93,48 µs    |      2,22 ms   |  389,30 µs  |   27,28 µs  |             |             |
| 65536                |  981,43 ms   |    30,69 µs    |    477,77 ms   |    5,48 ms  |  419,78 µs  |             |             |
