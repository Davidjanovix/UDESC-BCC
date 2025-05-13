#include <stdio.h>

int maior(int x, int y, int z);

int main() {
    int x, y, z;
    printf("Digite 3 numeros inteiros: ");
    scanf("%d %d %d", &x, &y, &z);
    printf("O maior numero e: %d\n", maior(x, y, z));
    return 0;
}

int maior(int x, int y, int z) {
    if (x >= y && x >= z) {
        return x;
    } else if (y >= x && y >= z) {
        return y;
    } else {
        return z;
    }
}