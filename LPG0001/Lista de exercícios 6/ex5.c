#include <stdio.h>

int *uniao( int *v1, int n1, int *v2, int n2, int *p3 ) {
    int i, j;
    for (i = 0; i < n1; i++) {
        p3[i] = v1[i];
    }
    for (j = 0; j < n2; j++) {
        p3[i + j] = v2[j];
    }
    return p3;
}

int main() {
    int v1[] = {1, 2, 3};
    int v2[] = {4, 5, 6};
    int p3[6];
    uniao(v1, 3, v2, 3, p3);
    for (int i = 0; i < 6; i++) {
        printf("%d ", p3[i]);
    }
    return 0;
}