#include <stdio.h>
int cnt[8005];
int main()
{
    int n,i,j,k,a[500005],max,b;
    max=0;
    double sum;
    sum=0;
    scanf("%d",&n);
    for(i=1;i<=n;i++) {
        scanf("%d",&k);
        cnt[k+4000]++;
        if(cnt[k+4000]>max) {
            max=cnt[k+4000];
        }
        sum+=k;
    }
    k=0;
    for(i=-4000;i<=4000;i++) {
        for(j=0;j<cnt[i+4000];j++) {
            a[k]=i;
            k++;
        }
    }
    k=0;
    b=0;
    for(i=0;i<=8000;i++) {
        if(max == cnt[i]) {
            k++;
            if(k == 2) {
                b=i;
                break;
            }
            b=i;
        }
    }
    if(n == 1) {
        b=a[0]+4000;
    }
    printf("%.0f\n",sum/n);
    printf("%d\n",a[n/2]);
    printf("%d\n",b-4000);
    printf("%d",a[n-1]-a[0]);
    return 0;
}