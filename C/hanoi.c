#include <stdio.h>

void hanoitowers(int,char,char,char);		//prototyping
int main() 
{ 
    int n; 
    printf("Δώσε τον αριθμό των κυλίνδρων:"); 
    scanf("%d",&n);
	printf("===============================\n"); 
    hanoitowers(n,'A','C','B'); 
    return 0; 
}
 
void hanoitowers(int N,char start,char target,char temp)		
{ 
	static int k=0;
    if (N>0)
       {
        hanoitowers(N-1, start, temp, target); 
        k+=1;
        printf("Κίνηση:%d\nΑπο τον στύλο %c στον στύλο %c\n\n",k,start,target); 
        hanoitowers(N-1, temp,target,start); 
       } 
} 