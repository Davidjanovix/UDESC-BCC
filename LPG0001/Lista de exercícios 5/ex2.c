#include <stdio.h>

void troca_valor(float *x, float *y) {
    float temp = *x;
    *x = *y;
    *y = temp;
}

int main() {
    float a = 5.5, b = 10.1;
    troca_valor(&a, &b);
    printf("a: %.2f, b: %.2f\n", a, b);
    return 0;
}
