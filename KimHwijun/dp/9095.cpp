#include <stdio.h>
int main()
{
    int n, a[1005], dp[1005], i, j, result[1005];
    scanf("%d",&n);
    
    //입력을 받음
    for(i=1; i<=n; i++) {
        scanf("%d",&a[i]);
    }
    
    //방법의 수를 나타내는 dp 배열
    
    //1에서의 방법의 수
    dp[1] = 1;
    //2에서의 방법의 수
    dp[2] = 2;
    //3에서의 방법의 수
    dp[3] = 4;
    for(i=1; i<=n; i++) {
        for(j=4; j<=a[i]; j++) {
            //n에서의 방법의 수는 n-1, n-2, n-3에서의 방법의 수를 합한 수와 같음
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }
        //결과를 저장하는 배열 result에 저장
        result[i] = dp[a[i]];
    }
    
    //결과를 순차적으로 출력
    for(i=1; i<=n; i++) {
        printf("%d\n",result[i]);
    }
    return 0;
}
