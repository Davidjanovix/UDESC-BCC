#include <stdio.h>

int main() {
    float x, seno, frac;
    int i, n;
    printf("Digite o valor de x: ");
    scanf("%f", &x);
    printf("Digite o numero de termos: ");
    scanf("%d", &n);
    for (i = 1, seno = x, frac = x ; i < n ; i++) {
        frac *= (-1) * x * x / ((i * 2) * (i * 2 + 1));
        seno += frac;
    }
    printf("O seno de %f e: %f\n", x, seno);
    return 0;
}