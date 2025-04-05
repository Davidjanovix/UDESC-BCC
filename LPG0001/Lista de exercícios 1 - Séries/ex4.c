#include <stdio.h>

int main() {
    int n, i;
    float e = 1, frac = 1;
    printf("Digite a quantidade de termos: ");
    scanf("%d", &n);
    for (i = 1 ; i < n ; i++) { //Contador inicia em 1 e o acumulador também
        frac *= (float) 1/i;    //Para não fazer a repetição quando i = 0
        e += frac;
    }
    printf("Resultado: %f\n", e);
    return 0;
}