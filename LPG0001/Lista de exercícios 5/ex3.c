#include <stdio.h>

void calcula_circulo(float raio, float *pPerimetro, float *pArea) {
    const float PI = 3.14159;
    *pPerimetro = 2 * PI * raio;
    *pArea = PI * raio * raio;
}

int main() {
    float raio = 5.0;
    float perimetro, area;
    calcula_circulo(raio, &perimetro, &area);
    printf("Perímetro: %.2f\n", perimetro);
    printf("Área: %.2f\n", area);
    return 0;
}
