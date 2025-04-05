#include <stdio.h>

int main() {
    int x, y, sum = 0;
    printf("Digite o valor de x: ");
    scanf("%d", &x);
    printf("Digite o valor de y: ");
    scanf("%d", &y);
    for (int i = x ; i <= y ; i+= 2) {
        if (i % 2 == 0 && i != y)   //Se o valor for par, já incrementa, pois a função incrementa o contador de 2 em 2 
            i++;                    //Para o caso do contador estar em um y par, ele não incrementa pois está fora do range
        sum += i;
    }
    printf("%d\n", sum);
    return 0;
}