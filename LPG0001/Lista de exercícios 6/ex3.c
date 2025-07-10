#include <stdio.h>

int main() {
    int n, i, count = 0;
    float *vetor, *acimaMedia;
    float soma = 0, media;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);

    vetor = (float *) malloc(n * sizeof(float));
    if (vetor == NULL) {
        printf("Erro de alocação.\n");
        return 1;
    }

    printf("Digite os valores:\n");
    for (i = 0; i < n; i++) {
        scanf("%f", &vetor[i]);
        soma += vetor[i];
    }

    media = soma / n;

    // Contar quantos são >= média
    for (i = 0; i < n; i++) {
        if (vetor[i] >= media)
            count++;
    }

    acimaMedia = (float *) malloc(count * sizeof(float));
    if (acimaMedia == NULL) {
        printf("Erro de alocação.\n");
        free(vetor);
        return 1;
    }

    // Copiar os valores maiores ou iguais à média
    int j = 0;
    for (i = 0; i < n; i++) {
        if (vetor[i] >= media)
            acimaMedia[j++] = vetor[i];
    }

    // Resultado
    printf("Média = %.2f\n", media);
    printf("Valores maiores ou iguais à média:\n");
    for (i = 0; i < count; i++) {
        printf("%.2f ", acimaMedia[i]);
    }
    printf("\n");

    // Liberação de memória
    free(vetor);
    free(acimaMedia);

    return 0;
}