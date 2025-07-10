#include <stdio.h>

void calcula_hora(int totalMinutos, int *ph, int *pm) {
    *ph = totalMinutos / 60; // Calcula as horas
    *pm = totalMinutos % 60; // Calcula os minutos restantes
}

int main() {
    int totalMinutos;
    int horas, minutos;
    printf("Quantos minutos se passaram desde as 00:00? ");
    scanf("%d", &totalMinutos);
    calcula_hora(totalMinutos, &horas, &minutos);
    printf("Horas: %d, Minutos: %d\n", horas, minutos);
    return 0;
}
