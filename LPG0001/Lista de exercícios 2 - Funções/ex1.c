#include <stdio.h>

int tipo_triangulo(float x, float y, float z);

int main() {
    float x, y, z;
    printf("Digite os lados do triangulo: ");
    scanf("%f %f %f", &x, &y, &z);
    switch(tipo_triangulo(x, y, z)) {
        case 0:
            printf("Nao forma triangulo\n");
            break;
        case 1:
            printf("Equilatero\n");
            break;
        case 2:
            printf("Isosceles\n");
            break;
        case 3:
            printf("Escaleno\n");
            break;
    }
    return 0;
}

int tipo_triangulo(float x, float y, float z) {
    if (x == y && y == z) {
        return 1;
    } else if (x == y || y == z || x == z) {
        return 2;
    } else {
        if(x + y <= z || x + z <= y || y + z <= x) {
            return 0;
        } else
            return 3;
    }
}