#include <stdio.h>

int soma_primos(int v[], int n);
int primo(int n);

int main() {
    int n;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);

    int v[n];

    printf("Digite os elementos do vetor:\n");

    for(int i = 0; i < n; i++) {
        printf("Elemento %d: ", i);
        scanf("%d", &v[i]);
    }

    printf("A soma dos primos no vetor e: %d\n", soma_primos(v, n));
    return 0;
}

int soma_primos(int v[], int n) {
    int soma = 0;

    for(int i = 0; i < n; i++)
        if(primo(v[i]))
            soma += v[i];

    return soma;
}

int primo(int n) {
    if (n < 2) 
        return 0;

    if (n == 2)
        return 1;

    for (int i = 2; i <= n / 2; i++)
        if (n % i == 0)
            return 0;

    return 1;
}