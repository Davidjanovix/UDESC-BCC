#include <stdio.h>
#define X 0 //Definindo os indices para facilitar a leitura do código
#define Y 1
#define S 2 //Índice para a soma

int main() {
    int n;
    printf("Digite o numero de casos: ");
    scanf("%d", &n);
    int casos[n][3]; //Criando uma matriz para armazenar os casos, 0 para x, 1 para y e 2 para a soma
    for (int i = 0 ; i < n ; i ++) {
        printf("Digite os valores de x e y: ");
        scanf("%d %d", &casos[i][X], &casos[i][Y]);
        casos[i][S] = 0; //Inicializando a soma como 0
        for (int j = casos[i][X] ; j <= casos[i][Y] ; j += 2) { //j vai iterar sobre cada valor entre x e y
            if (j % 2 == 0 && j != casos[i][Y])   //Se o valor for par, já incrementa, pois a função incrementa o contador de 2 em 2 
                j++;                             //Para o caso do contador estar em um y par, ele não incrementa pois está fora do range
            casos[i][S] += j;
        }
    }
    for (int i = 0 ; i < n ; i ++) {
        printf("%d\n", casos[i][S]);
    }
    return 0;
}