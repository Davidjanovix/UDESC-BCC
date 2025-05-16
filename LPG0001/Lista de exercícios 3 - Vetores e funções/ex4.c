#include <stdio.h>

void busca_todos(int v[], int n, int chave, int indices[]);

int main() {
    int n, chave;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);

    int v[n], indices[n];
    printf("Digite os elementos do vetor:\n");

    for(int i = 0; i < n; i++) {
        printf("Elemento %d: ", i);
        scanf("%d", &v[i]);
    }

    printf("Digite o elemento a ser buscado: ");
    scanf("%d", &chave);

    busca_todos(v, n, chave, indices);
    printf("O elemento %d foi encontrado nos indices: ", chave);

    for (int i = 0; i < n; i++) 
        if (indices[i] != -1)
            printf("%d ", indices[i]);

    printf("\n");
    return 0;
}

void busca_todos(int v[], int n, int chave, int indices[]) {
    int i, j = 0;
    
    for (i = 0; i < n; i++) 
        if(v[i] == chave)
            indices[j++] = i;
    
    while(j < n)
        indices[j++] = -1;
}