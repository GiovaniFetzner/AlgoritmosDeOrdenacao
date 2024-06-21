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

Para realizar os testes, é necessário acessar o arquivo, ler o vetor e selecionar o tipo de ordenação que será utilizado. Após essas escolhas, o vetor selecionado será ordenado e será impresso o tempo médio de execução das dez execuções de ordenação.



