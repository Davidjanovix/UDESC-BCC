#include <stdio.h>

double eIterativa(int n);
double eRecursiva(int n);

int main() {
    int n;
    printf("Digite o numero de repeticoes da serie: ");
    scanf("%d", &n);
    if (n < 0) {
        printf("Erro: n deve ser maior ou igual a 0\n");
        return 0;
    }
    printf("Valor de e (iterativa): %.15lf\n", eIterativa(n));
    printf("Valor de e (recursiva): %.15lf\n", eRecursiva(n));
    return 0;
}

double eIterativa(int n) {
    double e = 1.0;
    double fatorial = 1.0;
    for (int i = 1; i <= n; i++) {
        fatorial *= i;
        e += 1.0 / fatorial;
    }
    return e;
}

double eRecursiva(int n) {
    double fatorial = 1;
    if (n == 0) {
        return 1.0;
    } else {
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
    }
    return 1.0 / fatorial + eRecursiva(n - 1);
}