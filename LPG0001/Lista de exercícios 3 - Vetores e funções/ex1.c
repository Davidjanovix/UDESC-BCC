#include <stdio.h>

int compara(float a[], float b[], int n);

int main() {
    float a[5] = {1.0, 2.0, 3.0, 4.0, 5.0};
    float b[5] = {1.0, 2.0, 3.0, 4.0, 5.0};
    float c[5] = {1.0, 2.0, 3.0, 4.0, 6.0};

    printf("O vetor a e %s vetor b\n", compara(a, b, 5) ? "igual a" : "diferente do");
    printf("O vetor a e %s vetor c\n", compara(a, c, 5) ? "igual a" : "diferente do");

    return 0;
}

int compara(float a[], float b[], int n) {
    
    for (int i = 0; i < n; i++)
        if (a[i] != b[i])
            return 0;

    return 1;
}