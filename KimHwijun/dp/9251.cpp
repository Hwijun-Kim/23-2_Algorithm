#include <stdio.h>
#include <string.h>
#define max(a,b) (a > b ? a : b)

int main()
{
    int lcs[1005][1005];
    char a[1005];
    char b[1005];
    scanf("%s %s",a,b);
    int i, j;
    i = 1;
    while(i <= strlen(a))
    {
        j = 1;
        while (j <= strlen(b))
        {
            if (b[j-1] == a[i-1])
            {
                lcs[i][j] = lcs[i-1][j-1]+1;
            }
            else
            {
                lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
            }
            j++;
        }
        i++;
    }
    printf("%d", lcs[i-1][j-1]);
    return 0;
}
