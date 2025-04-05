#include <stdio.h>

float leibniz(int n);
float nilakantha(int n);
int main() {
    int termos, opt;
    float pi;
    printf("Digite o numero de termos: ");
    scanf("%d", &termos);
    do {
        printf("Selecione o método: \n");
        printf("[1] Leibniz\n[2] Nilakantha\n[0] Sair\n");
        printf("Opcao: ");
        scanf("%d", &opt);
        switch (opt) {
            case 1:
                printf("Resultado: %f\n", leibniz(termos));
                break;
            case 2:
            printf("Resultado: %f\n", nilakantha(termos));
                break;
            case 0:
                break;
            default:
                printf("Opçao invalida!\n");
                break;
        }
    } while (opt != 0 && opt != 1 && opt != 2);
    
    return 0;
}

float leibniz(int n) {
    float pi = 0;
    int i = 0;
    while (i < n) {
        if (i % 2) { //Se for ímpar, multiplica por 2, soma 1 e subtrai
            pi -= (float) 4 / (1 + 2 * i);
        } else { //Se for par, multiplica por 2, soma 1 e soma
            pi += (float) 4 / (1 + 2 * i);
        }
        i++;
    }
    return pi;
}
float nilakantha(int n) {
    float pi = 3, aux;
    int i = 1;
    while (i <= n) {
        if (i % 2) { //Se for ímpar
            aux = i * 2;
            pi += (float) 4 / (aux * (aux + 1) * (aux + 2));
        } else { //Se for par
            aux = i * 2;
            pi -= (float) 4 / (aux * (aux + 1) * (aux + 2));
        }
        i++;
    }
    return pi;
}