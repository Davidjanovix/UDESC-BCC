#include <stdio.h>

long long int somaSI(int n);
long long int somaSR(int n);

int main() {
    int n;
    printf("Digite um numero inteiro positivo: ");
    scanf("%d", &n);
    if (n < 1) {
        printf("Erro: n deve ser maior ou igual a 1\n");
        return 1;
    }
    printf("Soma iterativa: %lld\n", somaSI(n));
    printf("Soma recursiva: %lld\n", somaSR(n));
    return 0;
}

long long int somaSI(int n) {
    long long int soma = 0;
    for (int i = 1; i <= n; i++) {
        soma += i;
    }
    return soma;
}

long long int somaSR(int n) {
    if (n == 1) {
        return 1;
    }
    return n + somaSR(n - 1);
}