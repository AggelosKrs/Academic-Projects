#include <stdio.h>
#include <math.h>

int main(int argc, int **argv)
{
    int A, B;
    int C, D, E, F, G, H;
    //system ("chcp 1253");  //Διαγραφή αν τρέχει σε Linux
    printf ("Βασικές αριθμητικές πράξεις με Ακεραίους\n");
    printf ("========================================\n\n");
    printf ("Εισάγετε τον πρώτο αριθμό  : ");
    scanf ("%d",&A);
    printf ("Εισαγετε το δεύτερο αριθμό : ");
    scanf ("%d", &B);
    C = A + B;
    D = A - B;
    E = A * B;
    F = A / B;
    G = A * A;
    H = sqrt(B);
    printf ("Άθροισμα  : %d\n", C);
    printf ("Διαφορά   : %d\n", D);
    printf ("Γινόμενο  : %d\n", E);
    printf ("Πηλίκο    : %d\n", F);
    printf ("Τετράγωνο αριθμού : %d\n", G);
    printf ("Η τετραγωνική ρίζα του δεύτερου αριθμού : %d\n", H);
    return 0;
}
