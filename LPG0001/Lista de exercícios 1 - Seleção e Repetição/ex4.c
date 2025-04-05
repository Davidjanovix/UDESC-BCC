#include <stdio.h>

int main() {
    int n, 
        pares = 0, 
        impares = 0, 
        positivos = 0, 
        negativos = 0;

    printf("Digite quantos numeros voce vai digitar: ");
    scanf("%d", &n);
    int valores[n];
    for (int i = 0; i < n; i++) {
        printf("Digite o numero %d: ", i + 1);
        scanf("%d", &valores[i]);
        if (valores[i] < 0) {
            negativos++;
            if (valores[i] * (-1) % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        if (valores[i] > 0) {
            positivos++;
            if (valores[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
    }
    printf("%d valor(es) par(es)\n", pares);
    printf("%d valor(es) impar(es)\n", impares);
    printf("%d valor(es) positivo(s)\n", positivos);
    printf("%d valor(es) negativo(s)\n", negativos);
    return 0;
}