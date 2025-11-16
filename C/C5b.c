#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define N 4

int main()
{
    int i, x[N];
    int sum = 0, sum1 = 0, temp = 0, ART = 0;
    float MO, PER;

    for (i = 0; i <= N - 1; i++)
    {
        printf("Δώσε αριθμο x[%d]: ", i);
        scanf("%d", &x[i]);
        if (x[i] == 0)
            return 0;
    }

    for (i = 0; i <= N - 1; i++)
    {
        if (x[i] > 0)
        {
            temp = temp + 1;
            sum = sum + x[i];
            MO = sum / temp;
        }
        else if (x[i] < 0)
        {
            sum1 = x[1];
            sum1 = sum1 * x[i];
        }

        if (x[i] % 2 == 0)
        {
            ART = ART + 1;
        }
        else if (x[i] % 2 != 0)
        {
            PER = x[i] * x[i];
            printf("Το τράγωνο του %dου περιττού είναι: %f\n", i + 1, PER);
        }
    }
    printf("Ο Μέσος όρος ειναι: %f \n", MO);
    printf("Το γινόμενο τον αρνητικών είναι %d \n", sum1);
    printf("Το πλήθος των άρτιων είναι %d \n", ART);
    return 0;
}