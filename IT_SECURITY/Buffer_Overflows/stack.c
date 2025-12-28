#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int bof(char *str)
{
	char buffer[24];
	strcpy(buffer, str);
	printf("%p\n", &buffer);
	return 1;
}

int main(int argc, char const *argv[])
{
	char str[517];
	FILE *badfile;
	badfile = fopen("badfile", "r");
	fread(str, sizeof(char), 517, badfile);
	bof(str);
	printf("returned Properly\n");
	return 1;
}

