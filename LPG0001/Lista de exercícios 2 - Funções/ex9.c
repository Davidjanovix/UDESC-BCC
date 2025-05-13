#include <stdio.h>

double somaSerieHarmonicaI(int n);
double somaSerieHarmonicaR(int n);

int main() {
    int n;
    printf("Digite o numero de repeticoes da serie: ");
    scanf("%d", &n);
    if (n < 1) {
        printf("Erro: n deve ser maior ou igual a 1\n");
        return 1;
    }
    printf("Soma iterativa: %.15lf\n", somaSerieHarmonicaI(n));
    printf("Soma recursiva: %.15lf\n", somaSerieHarmonicaR(n));
    return 0;
}

double somaSerieHarmonicaI(int n) {
    double soma = 0;
    for (int i = 1; i <= n; i++) {
        soma += 1.0 / i;
    }
    return soma;
}

double somaSerieHarmonicaR(int n) {
    if (n == 1) {
        return 1;
    }
    return 1.0 / n + somaSerieHarmonicaR(n - 1);
}