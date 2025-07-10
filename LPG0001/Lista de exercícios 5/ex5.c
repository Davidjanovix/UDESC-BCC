#include <stdio.h>

void max_min(int vet[], int tam, int *pMin, int *pMax) {
    if (tam <= 0) return; // Verifica se o vetor está vazio

    *pMin = vet[0];
    *pMax = vet[0];

    for (int i = 1; i < tam; i++) {
        if (vet[i] < *pMin) {
            *pMin = vet[i];
        }
        if (vet[i] > *pMax) {
            *pMax = vet[i];
        }
    }
}

int main() {
    int vetor[] = {3, 5, 1, 8, 2};
    int min, max;
    max_min(vetor, 5, &min, &max);
    printf("Min: %d, Max: %d\n", min, max);
    return 0;
}
