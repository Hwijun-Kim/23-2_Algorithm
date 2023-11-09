# 대본
# 가장 왼쪽에서 한칸 옆의 스티커 하나를 뜯는다고 합시다.(인덱스, 위아래) 형식으로 표기할때 ,(1 위)을 뜯는 것입니다.
# 그러면 해당 스티커 좌,우,아래는 함께 뜯겨 나가고 (0,아래 )가 남게 됩니다.
# 즉, 마지막에 모든 스티커를 제거해야 하므로 (1,위)를 뜯으면 자동으로 (0,아래)도 뜯어야 하고(1,아래)와(0,위)는 함께 뜯겨야 합니다.

#이제 2번 인덱스부터는 선택지가 갈라집니다. 예를 들어 (2,위)를 뜯으려 할 때, 
# (1) (1,아래)을 선택하면 (0,위)도 자동으로 선택됩니다.
# (2) (0,아래) 선택
# 이때 (1)와 (2)중 더 큰값을 선택하면 됩니다.

#따라서, 2번 인덱스 부터는 위 조건으로 쭉 n까지 반복하여 최댓값을 얻을 수 있습니다.

import sys 
input = sys.stdin.readline

t = int(input())
for _ in range(t):
  n = int(input())
  
  dp = [list(map(int, input().split())) for _ in range(2)]

  dp[0][1] += dp[1][0]
  dp[1][1] += dp[0][0]

  # 맨끝에 시작 -> 둘중 하나는 무조건 고르게 됩니다.
  # ex - (1, 위) 선택 => (0,아래) 선택됨
  # 2번 인덱스 부터는 선택지가 갈린다. 예를 들어 (2 위) 선택 시
  # (1) (1,아래)을 선택하면 (0,위)도 자동으로 선택된다.
  # (2) (0,아래) 선택
  # (1) 과 (2) 중 큰 값을 선택한다.

  for i in range (2,n):
    dp[0][i] += max(dp[1][i-1], dp[1][i-2])
    dp[1][i] += max(dp[0][i-1], dp[0][i-2])

  print(max(dp[0][n-1], dp[1][n-1]))