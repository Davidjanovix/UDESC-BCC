#include <stdio.h>

int main() {
    int n, i;
    float e_x = 1, frac = 1, x;
    printf("Digite o valor de x: ");
    scanf("%f", &x);
    printf("Digite a quantidade de termos: ");
    scanf("%d", &n);
    for (i = 1 ; i < n ; i++) { //Contador inicia em 1 e o acumulador também
        frac *= x/i;    //Para não fazer a repetição quando i = 0
        e_x += frac;
    }
    printf("Resultado de e elevado a %f: %f\n", x, e_x);
    return 0;
}