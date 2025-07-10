#include <stdio.h>

char *repetidor( char *s, int n ) {
    static char resultado[100]; // Buffer estático para armazenar o resultado
    int pos = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; s[j] != '\0'; j++) {
            resultado[pos++] = s[j];
        }
    }
    resultado[pos] = '\0'; // Termina a string com o caractere nulo

    return resultado;
}

int main() {
    char *str = "Hello";
    char *repetida = repetidor(str, 3);
    printf("%s\n", repetida);
    return 0;
}