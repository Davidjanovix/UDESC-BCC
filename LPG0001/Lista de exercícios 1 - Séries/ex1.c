#include <stdio.h>

int main () {
    int k, i = 0;
    float sum = 0;
    printf("Digite o numero de termos: ");
    scanf("%d", &k);
    while (i < k) {
        sum += (float) 1/++i;
    }
    printf("Resultado da soma: %f", sum);
    return 0;
}