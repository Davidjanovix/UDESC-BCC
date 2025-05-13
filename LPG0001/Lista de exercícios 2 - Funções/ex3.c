#include <stdio.h>

int verificar(char c);
int toInt(char c);

int main() {
    char c;
    int num;
    printf("Digite um numero: ");
    c = getchar();
    if (verificar(c)) {
        num = toInt(c);
        printf("O numero digitado foi: %d\n", num);
    } else {
        printf("Nao e um numero\n");
    }
    return 0;
}

int verificar(char c) {
    if (c >= '0' && c <= '9') {
        return 1;
    } else
        return 0;
}

int toInt(char c) {
    return c - '0';
}