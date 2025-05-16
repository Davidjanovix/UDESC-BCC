#include <stdio.h>

void fibonacci(int v[], int n);

int main() {
    int n;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);

    int v[n];
    fibonacci(v, n);

    for(int i = 0; i < n; i++)
        printf("%d\n", v[i]);

    return 0;
}

void fibonacci(int v[], int n) {
    if (n < 1) 
        return;

    v[0] = 1;
    if (n == 1) 
        return;

    v[1] = 1;
    for (int i = 2; i < n; i++)
        v[i] = v[i - 1] + v[i - 2];
}