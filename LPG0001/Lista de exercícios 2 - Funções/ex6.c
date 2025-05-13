#include <stdio.h>

int fibo(int n);

int main() {
    int n;
    printf("Digite o número de termos da sequência de Fibonacci: ");
    scanf("%d", &n);
    fibo(n);
    printf("\n");
    return 0;
}

int fibo(int n) {
    if(n < 0 || n == 0) {
        printf("Erro: n deve ser maior ou igual a 1\n");
        return 0;
    } else if (n == 1) {
        printf("1 ");
        return 1;
    }
    int a = 1, b = 1, c;
    printf("%d ", a);
    printf("%d ", b);
    for(int i = 2 ; i < n ; i++) {
        c = a + b;
        a = b;
        b = c;
        printf("%d ", c);
    }
    return 1;
}