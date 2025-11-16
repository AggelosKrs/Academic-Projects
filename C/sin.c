#include <stdio.h>
#include <math.h>
#define pi 3.14159265
#define acc 10e-6

double fact(double),pow(double,double),degreestorad(double),Mysin(double);     // prototyping 
int inputdata(int);

int main()
{
	int d, deg;
	double x;
	d=inputdata(deg);
	x=degreestorad(d);
	printf("Το sin(%d)=%lf\n",d,Mysin(x));
	printf("Το sin(%d)=%lf\n",d,sin(x));
	return 0; 
}


int inputdata(int deg)		//εισαγωγή μοιρών
{
	do 
	{
		printf("Δώστε την γωνία σε μοίρες:");
		scanf("%d",&deg);
		if(deg<0 || deg>360)		//έλεγχος ορίων		
		{
			printf("Δώστε νέα γωνία μεταξύ 0 και 360 μοιρών.\n");
		}
	}
	while (deg<0 || deg>360);
	return deg;	
}



double degreestorad(double a)		// μετατροπή μοιρών σε radians 
{
	return (a*pi)/180;	
}



double pow(double k, double n)		// υπολογισμός δύναμης
{
	int i;
	double p=1.0;
	for(i=1;i<=n;i++)
	p*=k;
	return p;
}



double fact(double x)		//υπολογισμός παραγωντικού 
{
	if (x==0 || x==1)
		return 1;
	else
		return x*fact(x-1);
} 



double Mysin(double x)		//υπολογισμός ημιτόνου
{
	int p,sign;
	double sum,term,l;
	p=1;
	sign=1;
	sum=0.0;
	term=1.0;
	 do
	{
		l=term;
		term=(pow(x,p)/fact(p));
	    sum+=sign*(term);
	    sign*=(-1);
	    p+=2;
	}
	while (fabs(l-term)>acc);
	return sum;
}