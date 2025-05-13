#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int compara(float a[], float b[], int n);

int main() {
    int n;
    srand(time(NULL));

    printf("Digite o numero de elementos do vetor: ");
    scanf("%d", &n);
    float a[n], b[n];

    for (int i = 0; i < n; i++) {
        a[i] = (float)(rand() % 1000) / 100.0; //Gera números entre 0 e 9.99 com 2 casas decimais.
        b[i] = a[i];
    }

    if(compara(a, b, n)) {
        printf("Os vetores sao iguais\n");
    } else {
        printf("Os vetores sao diferentes\n");
    }

    return 0;
}

int compara(float a[], float b[], int n) {
    int i;
    for (i = 0 ; i < n ; i++) {
        if (a[i] != b[i]) {
            return 0;
        }
    }
    return 1;
}