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
| 128                  |   89,63 µs   |     4,42 µs    |    152,81 µs   |   20,64 µs  |   30,96 µs  |   31,98 µs  |  35,06 µs   |
| 256                  |   94,36 µs   |     4,90 µs    |    151,80 µs   |   24,41 µs  |   69,40 µs  |   35,27 µs  |  39,53 µs   |
| 512                  |   96,54 µs   |    14,43 µs    |     59,66 µs   |   71,50 µs  |  150,67 µs  |   49,90 µs  |  46,11 µs   |
| 1024                 |  356,76 µs   |    25,80 µs    |    177,22 µs   |  139,00 µs  |   52,68 µs  |   84,66 µs  |  40,56 µs   |
| 2048                 |    1,29 ms   |    50,16 µs    |    695,41 µs   |  293,41 µs  |   67,78 µs  |  122,08 µs  |  82,01 µs   |
| 4096                 |    3,14 ms   |    93,48 µs    |      2,22 ms   |  389,30 µs  |   27,28 µs  |  200,10 µs  | 119,90 µs   |
| 65536                |  981,43 ms   |    30,69 µs    |    477,77 ms   |    5,48 ms  |  419,78 µs  |   2,25 ms   |   2,87 ms   |

#### Tabela 2. Tempos computados para Vetor ordenado em ordem decrescente e sem valores repetidos 

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  330,36 µs   |   300,61 µs    |    170,90 µs   |   38,68 µs  |   44,77 µs  |   49,90 µs  |  46,91 µs   |
| 256                  |   89,94 µs   |   151,54 µs    |     95,63 µs   |   48,08 µs  |  123,14 µs  |   30,10 µs  |  45,85 µs   |
| 512                  |  370,81 µs   |   219,27 µs    |    262,71 µs   |  104,64 µs  |   99,90 µs  |   68,11 µs  |  66,60 µs   |
| 1024                 |    1,29 ms   |   438,37 µs    |    552,56 µs   |  215,61 µs  |  142,68 µs  |  142,63 µs  | 164,11 µs   |
| 2048                 |    5,03 ms   |     1,57 ms    |      1,80 ms   |  417,75 µs  |   80,65 µs  |  213,35 µs  | 136,78 µs   |
| 4096                 |   18,12 ms   |     6,48 ms    |      7,35 ms   |  517,61 µs  |  195,33 µs  |  325,76 µs  | 263,43 µs   |
| 65536                |    5,09  s   |     1,91  s    |      2,01  s   |    9,25 ms  |    2,83 ms  |   4,74 ms   |   4,30 ms   |

#### Tabela 3. Tempos computados para Vetor aleatório sem valores repetidos 

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  338,34 µs   |   632,57 µs    |    431,64 µs   |   33,80 µs  |   84,08 µs  |   95,16 µs  |  66,24 µs   |
| 256                  |  212,14 µs   |   379,05 µs    |    269,20 µs   |   59,64 µs  |  248,21 µs  |   43,03 µs  |  65,11 µs   |
| 512                  |  489,65 µs   |   525,79 µs    |    230,01 µs   |  131,31 µs  |  176,76 µs  |   91,58 µs  |  88,39 µs   |
| 1024                 |    1,83 ms   |     1,37 ms    |    801,10 µs   |  278,52 µs  |  364,35 µs  |  175,61 µs  | 172,01 µs   |
| 2048                 |    5,04 ms   |     4,34 ms    |      1,93 ms   |  598,26 µs  |  377,08 µs  |  285,58 µs  | 209,46 µs   |
| 4096                 |   22,59 ms   |    19,19 ms    |      6,45 ms   |  791,17 µs  |  891,88 µs  |  547,94 µs  | 418,29 µs   |
| 65536                |   10,04  s   |     3,26  s    |      1,03  s   |   12,84 ms  |   27,55 ms  |   8,87 ms   |   8,90 ms   |

#### Tabela 4. Tempos computados para Vetor aleatório com valores repetidos 

| Tamanho do Array (n) | Bubble Sort  | Insertion Sort | Selection Sort | Heap Sort   | Shell Sort  | Merge Sort  | Quick Sort  |
|----------------------|--------------|----------------|----------------|-------------|-------------|-------------|-------------|
| 128                  |  257,45 µs   |   327,86 µs    |    222,73 µs   |   25,47 µs  |   59,96 µs  |   41,19 µs  |  50,08 µs   |
| 256                  |  200,84 µs   |   226,07 µs    |    148,23 µs   |   65,43 µs  |  219,13 µs  |   43,85 µs  |  48,80 µs   |
| 512                  |  640,70 µs   |   342,51 µs    |    164,57 µs   |  114,70 µs  |  139,61 µs  |   83,81 µs  |  87,56 µs   |
| 1024                 |    1,69 ms   |     1,02 ms    |    494,66 µs   |  232,90 µs  |  194,12 µs  |  180,99 µs  | 185,07 µs   |
| 2048                 |    5,09 ms   |     3,26 ms    |      1,14 ms   |  532,64 µs  |  376,53 µs  |  265,75 µs  | 238,87 µs   |
| 4096                 |   19,79 ms   |    12,35 ms    |      3,69 ms   |  796,93 µs  |  992,34 µs  |  418,38 µs  | 425,77 µs   |
| 65536                |    8,37  s   |     3,13  s    |    715,65 ms   |   14,57 ms  |   29,34 ms  |   7,21 ms   |   8,08 ms   |