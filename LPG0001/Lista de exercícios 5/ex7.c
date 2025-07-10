#include <stdio.h>

void min_matriz(float mat[3][4], float *pMin, int *pI, int *pJ) {
    *pMin = mat[0][0];
    *pI = 0;
    *pJ = 0;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            if (mat[i][j] < *pMin) {
                *pMin = mat[i][j];
                *pI = i;
                *pJ = j;
            }
        }
    }
}

int main() {
    float matriz[3][4] = {
        {3.5, 5.1, 1.8, 8.2},
        {2.9, 4.0, 6.3, 7.1},
        {9.0, 0.5, 2.2, 3.3}
    };
    float min;
    int i, j;
    min_matriz(matriz, &min, &i, &j);
    printf("Min: %.2f, Indice: [%d][%d]\n", min, i, j);
    return 0;
}
