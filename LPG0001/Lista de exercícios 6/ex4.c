#include <stdio.h>

int main() {
    int n, i, valor;
    int *v = NULL;   // Vetor original
    int *vp = NULL;  // Vetor de positivos
    int *vn = NULL;  // Vetor de negativos
    int tam_p = 0, tam_n = 0;

    printf("Quantos valores deseja inserir? ");
    scanf("%d", &n);

    v = (int *) malloc(n * sizeof(int));
    if (v == NULL) {
        printf("Erro ao alocar vetor v.\n");
        return 1;
    }

    // Leitura e separação
    for (i = 0; i < n; i++) {
        printf("Digite o %dº valor: ", i + 1);
        scanf("%d", &v[i]);

        if (v[i] > 0) {
            int *temp = realloc(vp, (tam_p + 1) * sizeof(int));
            if (temp == NULL) {
                printf("Erro ao realocar vetor vp.\n");
                free(v); free(vp); free(vn);
                return 1;
            }
            vp = temp;
            vp[tam_p++] = v[i];
        } else if (v[i] < 0) {
            int *temp = realloc(vn, (tam_n + 1) * sizeof(int));
            if (temp == NULL) {
                printf("Erro ao realocar vetor vn.\n");
                free(v); free(vp); free(vn);
                return 1;
            }
            vn = temp;
            vn[tam_n++] = v[i];
        }
        // Zeros são ignorados
    }

    // Impressão dos vetores
    printf("\nVetor original:\n");
    for (i = 0; i < n; i++)
        printf("%d ", v[i]);

    printf("\n\nVetor de positivos:\n");
    for (i = 0; i < tam_p; i++)
        printf("%d ", vp[i]);

    printf("\n\nVetor de negativos:\n");
    for (i = 0; i < tam_n; i++)
        printf("%d ", vn[i]);

    printf("\n");

    // Liberação de memória
    free(v);
    free(vp);
    free(vn);

    return 0;
}
