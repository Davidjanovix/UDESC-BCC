#include <stdio.h>

void inc_dec (int *a, int *b) {
    (*a)++;
    (*b)--;
}
int main() {
    int x = 5, y = 10;
    inc_dec(&x, &y);
    printf("x: %d, y: %d\n", x, y);
    return 0;
}
