#include <stdio.h>

int main() {
    int n;
    printf("Digite quantos casos terao: ");
    scanf("%d", &n);
    float casos[n][3], media[n];
    for (int i = 0; i < n; i++) {
        printf("Digite os valores de a, b e c: ");
        scanf("%f %f %f", &casos[i][0], &casos[i][1], &casos[i][2]);
        media[i] = (casos[i][0] * 2 + casos[i][1] * 3 + casos[i][2] * 5) / 10;
    }
    for (int i = 0; i < n; i++) {
        printf("%.1f\n", media[i]);
    }
    return 0;
}