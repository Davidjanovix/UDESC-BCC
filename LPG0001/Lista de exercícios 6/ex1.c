#include <stdio.h>

float *clone( float *v, int n ) {
    float *novo = (float *)malloc(n * sizeof(float));
    if (novo != NULL) {
        for (int i = 0; i < n; i++) {
            novo[i] = v[i];
        }
    }
    return novo;
}

int main() {
    float vetor[] = {1.0, 2.0, 3.0};
    float *copia = clone(vetor, 3);
    if (copia != NULL) {
        for (int i = 0; i < 3; i++) {
            printf("copia[%d] = %.2f\n", i, copia[i]);
        }
        free(copia);
    }
    else {
        printf("Falha ao alocar memória.\n");
    }
    return 0;
}