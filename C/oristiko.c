#include <stdio.h>
#include <stdlib.h>

int akeraioi();
void B2();
void B3();
int *alloc_table(int);
void fill_table(int*,int);
int Same(int*,int,int);
int check1(int*,int,int);
int check2(int*,int,int);
void sort(int*,int);
int print_six(int*,int);
void statistics(int,int,int,int);
void calculate(int*,int,int,int,int,int,int*,int*,int*);
void assemble_six(int*,int,int,int,int,int,int,int*);
int akeraioi();


int main()
{
    int *table;
    int sum,x1,x2,y1,y2,f;
    int Term1,Term2,Max;
    B2(&x1,&x2);
    B3(&y1,&y2);
    sum=akeraioi();
    table=alloc_table(sum);
    fill_table(table,sum);
    sort(table,sum);
    calculate(table,sum,x1,x2,y1,y2,&Max,&Term1, &Term2);
	statistics(Max,Term1,Term2,f);
	free(table);
    return 0;
}

/* Άσκηση 1β*/
int akeraioi()
{
    int x;

    do
    {
        printf("Δώσε διαφορετικούς ακέραιου απο 1-49: ");
        scanf("%d", &x);
        if (x < 6 || x > 49)
            printf("Ξαναδώσε αριθμό από x>6 και x<49");
    } while (x < 6 || x > 49);
    return x;
}

/* Άσκηση 2β*/

void B2()
{
    int x1, x2;
    printf("Δώσε ζεύγος αριρμών [0<=x1<=x2<=6].\n");
    do
    {
        printf("Δώσε το χ1");
        scanf("%d", &x1);
    } while (x1 < 0 || x1 > 6);
    do
    {
        printf("Δώσε το χ2");
        scanf("%d", &x2);
    } while (x1 > x2);
}

/* Άσκηση 3Β*/
void B3()
{
    int y1, y2;
    printf("Δώσε ζεύγος αριρμών [21<=x1<=x2<=279].\n");
    do
    {
        printf("Δώσε το y1");
        scanf("%d", &y1);
    } while (y1 < 21 || y1 > 279);
    do
    {
        printf("Δώσε το y2");
        scanf("%d", &y2);
    } while (y1 > y2);
}

// Άσκηση 4-5Β
int *alloc_table(int s){
	int *table;
	int i;
	table=(int*)malloc(s*sizeof(int));
	if(table==NULL)
		exit (46);
		return table;
}

int check1(int *table,int x1,int x2)
{
	int i,a;
	a=0;
	for(i=0;i<6;i++)
		if(*(table+1)%2==0)
			a++;
		if(a>=x1 && a<=x2)
			return 1;
	return 0;
}

int check2(int *table,int y1,int y2)
{
	int i,k;
	k=0;
	for(i=0;i<6;k+=*(table+i++));
		if(k>=y1 && k<=y2)
			return 1;
	return 0;
}

void fill_table(int *t,int x)
{
	int i;	
	for(i=0;i<x;i++)
	{
		do
		{
			printf ("Δώσε αριθμό %d για την θέση του πίνακα: ", i + 1);
       		scanf ("%d", t + i); 
		}
		while(*(t+i)<1 || *(t+i)>49);
	}
}

int Same(int *t,int p,int i)
{
	int j;
	for(j=0;j<i && *(t+i)!=p;j++);
		if(j==i)
			return 0;
		return 1;
}
//Άσκηση 6B
void sort(int *table,int s)
{
	int i,j,temp;
	for(i=0;i<s-1;i++)
		for(j=i+1;j<s;j++)
			if(*(table+i)>*(table+j))
			{
				temp=*(table+i);
				*(table+i)=*(table+j);
				*(table+j)=temp;
			}	
}
//Άσκηση 7B
void calculate(int *table,int sum,int x1,int x2,int y1,int y2,int *Max,int *c1,int *c2)
{
	int a,b,c,d,e,f,S;
	int *(six);
	S=0;
	for(a=0;a<sum-5;a++)
		for(b=a+1;a<sum-4;a++)
			for(c=b+1;a<sum-3;c++)
				for(d=c+1;a<sum-2;d++)
					for(e=d+1;a<sum-1;e++)
						for(f=e+1;a<sum;f++)
						{
							*(Max)++;
							assemble_six(table,a,b,c,d,e,f,six);
							if(check1(six,x1,x2))
								if(check2(six,y1,y2))
									print_six(six,++S);
								else
									(*c2)++;
								else 
									(*c1)++;
						}
}

//Άσκηση 8Β
void assemble_six(int *table,int q,int w,int e,int r,int t,int y,int *pin)
{
	*(pin+0)=*(table+q);
	*(pin+1)=*(table+w);
	*(pin+2)=*(table+e);
	*(pin+3)=*(table+r);
	*(pin+4)=*(table+t);
	*(pin+5)=*(table+y);		
}

//Άσκηση 9Β
int print_six(int *pin,int f)
{
	printf("\n[%d] %d %d %d %d %d %d\n",f,*(pin+0),*(pin+1),*(pin+2),*(pin+3),*(pin+4),*(pin+5));	
}

void statistics(int Max,int Term1,int Term2, int fr)
{
	int a;
	printf("Στατιστικά αποτελέσματα.");
	printf("Ελέγχηκαν %d εξάδες.",Max);
	printf("%d εξάδες δεν πληρούν τον πρώτο περιορισμό.",Term1);
	printf("%d εξάδες δεν πληρούν τον δεύτερο περιορισμό.",Term2);
	printf("Πλήθος αποδεκτών εξάδων:%d",Max-(Term1-Term2));
}