#include <stdio.h>

int busca_seq_rec(int v[], int n, int chave);

int main() {
    int n, chave;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);

    int v[n];
    printf("Digite os elementos do vetor:\n");

    for(int i = 0; i < n; i++) {
        printf("Elemento %d: ", i);
        scanf("%d", &v[i]);
    }

    printf("Digite o elemento a ser buscado: ");
    scanf("%d", &chave);
    
    printf("O elemento %d foi encontrado no indice: %d\n", chave, busca_seq_rec(v, n, chave));
    return 0;
}

int busca_seq_rec(int v[], int n, int chave) {
    if (n == 0) 
        return -1;

    if (v[n - 1] == chave) 
        return n - 1;

    return busca_seq_rec(v, n - 1, chave);
}