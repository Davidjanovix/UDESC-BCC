#include <stdio.h>

void max_vetor(float vet[], int tam, float *pMax, int *pIndice) {
    if (tam <= 0) return; // Verifica se o vetor está vazio

    *pMax = vet[0];
    *pIndice = 0;

    for (int i = 1; i < tam; i++) {
        if (vet[i] > *pMax) {
            *pMax = vet[i];
            *pIndice = i;
        }
    }
}

int main() {
    float vetor[] = {3.5, 5.1, 1.8, 8.2, 2.9};
    float max;
    int indice;
    max_vetor(vetor, 5, &max, &indice);
    printf("Max: %.2f, Indice: %d\n", max, indice);
    return 0;
}
