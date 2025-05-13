#include <stdio.h>

long long int somatorio(int n, int k, int x);

int main() {
    int n, k, x;
    printf("Digite o valor de n: ");
    scanf("%d", &n);
    printf("Digite o valor de k: ");
    scanf("%d", &k);
    printf("Digite o valor de x: ");
    scanf("%d", &x);
    if (n <= 0 || k <= 0 || x <= 0) {
        printf("Erro: n, k e x devem ser maiores que 0\n");
        return 1;
    }
    printf("O somatorio e: %lld\n", somatorio(n, k, x));
    return 0;
}

long long int somatorio(int n, int k, int x) {
    long long int soma = 0;
    int multiplo = (x % k == 0) ? x : (x / k) * (k + 1);
    
    for (int i = 0; i < n; i++) {
        soma += multiplo;
        multiplo += k;
    }
    return soma;
}