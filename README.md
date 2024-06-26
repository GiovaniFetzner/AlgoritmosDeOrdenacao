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
| 128                  |  249,06 µs   |     4,38 µs    |    153,38 µs   |             |             |             |             |
| 256                  |  253,08 µs   |     5,30 µs    |    202,52 µs   |             |             |             |             |
| 512                  |  100,19 µs   |    13,13 µs    |    245,58 µs   |             |             |             |             |
| 1024                 |  445,15 µs   |    27,96 µs    |    179,41 µs   |             |             |             |             |
| 2048                 |    1,70 ms   |    52,32 µs    |    538,59 µs   |             |             |             |             |
| 4096                 |    5,29 ms   |    62,04 µs    |      2,46 ms   |             |             |             |             |
| 65536                |    1,25 s    |    69,74 µs    |    569,50 ms   |             |             |             |             |


#### Tabela 2. Tempos computados para Vetor ordenado em ordem decrescente e sem valores repetidos

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  222,65 µs   |   276,28 µs    |    113,12 µs   |             |             |             |             |
| 256                  |  206,00 µs   |   168,91 µs    |    120,91 µs   |             |             |             |             |
| 512                  |  301,23 µs   |   189,86 µs    |    241,17 µs   |             |             |             |             |
| 1024                 |    1,15 ms   |   431,91 µs    |    542,57 µs   |             |             |             |             |
| 2048                 |    4,30 ms   |     1,63 ms    |      1,82 ms   |             |             |             |             |
| 4096                 |   19,09 ms   |     6,30 ms    |      6,73 ms   |             |             |             |             |
| 65536                |     6,03 s   |      2,16 s    |      2,26  s   |             |             |             |             |

#### Tabela 3. Tempos computados para Vetor aleatório sem valores repetidos

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  234,77 µs   |   172,73 µs    |    153,05 µs   |             |             |             |             |
| 256                  |  279,11 µs   |   154,72 µs    |    127,59 µs   |             |             |             |             |
| 512                  |  376,47 µs   |   218,28 µs    |    210,30 µs   |             |             |             |             |
| 1024                 |    1,27 ms   |   684,83 µs    |    304,94 µs   |             |             |             |             |
| 2048                 |    3,80 ms   |     2,09 ms    |    837,39 µs   |             |             |             |             |
| 4096                 |   15,50 ms   |     8,64 ms    |      2,86 ms   |             |             |             |             |
| 65536                |    10,10 s   |      3,09 s    |   758,50  ms   |             |             |             |             |

#### Tabela 4. Tempos computados para Vetor aleatório com valores repetidos

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  237,67 µs   |   175,82 µs    |    107,21 µs   |             |             |             |             |
| 256                  |  202,91 µs   |   113,58 µs    |    126,73 µs   |             |             |             |             |
| 512                  |  423,15 µs   |   248,88 µs    |    565,11 µs   |             |             |             |             |
| 1024                 |    1,21 ms   |   674,57 µs    |    257,71 µs   |             |             |             |             |
| 2048                 |    4,55 ms   |     2,21 ms    |    903,51 µs   |             |             |             |             |
| 4096                 |   20,21 ms   |     9,58 ms    |      2,92 ms   |             |             |             |             |
| 65536                |    11,33 s   |     3,03 s     |    737,32 ms   |             |             |             |             |

Note que para cada registro na tabela foi realizado **somente** o tempo de execução, sem considerar desvio padrão nem variância
