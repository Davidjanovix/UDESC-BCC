#include <stdio.h>

int main() {
    int inicio, termino, duracao;
    printf("Digite o horario de inicio: ");
    scanf("%d", &inicio);
    printf("Digite o horario de termino: ");
    scanf("%d", &termino);
    if (termino <= inicio) {
        termino += 24;
    }
    duracao = termino - inicio;
    printf("O JOGO DUROU %d HORA(S)\n", duracao);
    return 0;
}