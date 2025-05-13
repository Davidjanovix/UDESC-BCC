#include <stdio.h>

int somaImpares(int x, int y);

int main() {
    int x, y;
    printf("Digite dois numeros inteiros: ");
    scanf("%d %d", &x, &y);
    printf("A soma dos impares entre %d e %d e: %d\n", x, y, somaImpares(x, y));
    return 0;
}

int somaImpares(int x, int y) {
    int soma = 0;
    if(x > y) {
        int temp = x;
        x = y;
        y = temp;
    }
    for (int i = x + 1; i < y; i++) {
        if (i % 2 != 0) {
            soma += i++; //Pós incremento, pra pular o próximo número par, forçando o laço a só verificar no máximo um par.
        }
    }
    return soma;
}