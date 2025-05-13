#include <stdio.h>

int primo(int x);
int* primos(int k, int n);

int main() {
    int k, n;
    printf("Digite um número inteiro positivo: ");
    scanf("%d", &k);
    printf("Digite a quantidade de primos a serem gerados: ");
    scanf("%d", &n);
    int* arr = primos(k, n);
    if (arr == NULL) {
        printf("Erro ao alocar memoria\n");
        return 1;
    }
    printf("Os %d primos a partir de %d sao: ", n, k);
    for(int i = 0 ; i < n ; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    free(arr); // Libera a memória alocada
    return 0;
}

int primo(int x) {
    if (x < 2) {
        return 0;
    } else if (x == 2) {
        return 1;
    } else if (x % 2 == 0) {
        return 0;
    }
    for (int i = 2; i <= x / 2; i++) {   //Condição i <= x / 2, pois o maior divisor de um número além dele mesmo é a sua metade.
        if (x % i == 0) {               
            return 0;
        }
    }
    return 1;
}

int* primos(int k, int n) {
    int* arr = (int*)malloc(n * sizeof(int)); // Alocando memória para n inteiros
    if (arr == NULL) {
        return NULL; // Retorna NULL se a alocação falhar
    }
    for(int i = 0 ; i < n ; ) {
        if (primo(++k)) {
            arr[i++] = k;
        }
    }
    return arr;
}