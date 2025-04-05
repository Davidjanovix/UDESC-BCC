#include <stdio.h>

int main () {
    int k, i = 0;
    float sum = 0;
    printf("Digite o numero de termos: ");
    scanf("%d", &k);
    while (i < k) {
        if(++i % 2) { //Se o termo é ímpar, soma-se a fração
            sum += (float) 1 / i;
        } else { //Se o termo é par, subtrai-se a fração
            sum -= (float) 1 / i;
        }
    }
    printf("Resultado: %f", sum);
    return 0;
}