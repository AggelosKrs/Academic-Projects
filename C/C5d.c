#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double parag(int);

int main()
{
    int i = 1, N, x;

    printf("Δώσε μέγαθος ακολουθίας: ");
    scanf("%d",&N);

    for(i=1;i<=N;i+=2)
    {
        printf("Δώσε αριθμούς");
        scanf("%d",&x);
    }
    return 0;
}