/*Τρίγωνα με χρήση πίνακα */
#include <stdio.h>

int i, j;
/*Dhlwsh pinakwn*/
int pinakas(int x);
int anapodos(int x);
int trigono(int x);
int teliko(int x);

int main()
{
    /* οι δηλώσεις των μεταβλητών εδώ δουλεύουν 
    μόνο για την main */
    int megethos, c, d, e, f;

    printf("Δώσε μέγεθος τριγώνου:");
    scanf("%d", &megethos);

    c = pinakas(megethos);
    d = anapodos(megethos);
    e = trigono(megethos);
    f = teliko(megethos);

    return 0;
}

int pinakas(int x)
{
    for (i = 0; i <= x; i++)
    {
        for (j = 1; j <= i; j++)
            printf("*");
        printf("\n");
    }
    printf("\n");
}

int anapodos(int x)
{
    for (i = 1; i <= x; i++)
    {
        for (j = x; j >= i; j--)
            printf(" ");
        for (j = 1; j <= i; j++)
            printf("*");
        printf("\n");
    }
    printf("\n");
}

int trigono(int x)
{
    for (i = 1; i <= x; i++)
    {
        for (j = 1; j <= x - i; j++)
            printf(" ");
        for (j = 1; j <= 2 * i - 1; j++)
            printf("*");
        printf("\n");
    }
    printf("\n");
}

int teliko(int x)
{
    for (i = 1; i <= x; i++)
    {
        for (j = 1; j <= x; j++)
        {
            if (j == x || j == 1 || i == 1 || i == x || j == x)
                printf("*");
            else if (j == i || j == x - (i - 1))
                printf(".");
            else
                printf(" ");
        }
        printf("\n");
    }
}
