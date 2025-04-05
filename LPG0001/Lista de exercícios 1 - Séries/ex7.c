#include <stdio.h>

int main() {
    float x, cosseno = 1, frac = 1;
    int i, n;
    printf("Digite o valor de x: ");
    scanf("%f", &x);
    printf("Digite o numero de termos: ");
    scanf("%d", &n);
    for (i = 1 ; i < n ; i++) {
        frac *= (-1) * x * x / ((i * 2) * (i * 2 - 1));
        cosseno += frac;
    }
    printf("O cosseno de %f e: %f\n", x, cosseno);
    return 0;
}