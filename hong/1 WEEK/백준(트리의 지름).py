import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**9)
# 러닝 타임 줄이는 재귀 최대 깊이 조절하는 코드

n = int(input()) # 트리 안에 노드들이 존재하기 때문에 2차원 배열을 만들어야 한다.
graph = [[] for _ in range(n + 1)] # 범위가 n+1인 2차원 배열을 생성한다.

# dfs 탐색
def dfs(x, wei):# 시작 노드 번호, 현재 노드 가중치

    # 트리를 내려가면서 반복문을 통해 현재 노드와 연결된 노드, 연결된 노드의 가중치를 확인한다.
    for i in graph[x]:

        # 탐색 하지 않은 노드라면 탐색한다.
        a, b = i # x와 wei를 i로 둔다.
        if distance[a] == -1:  
            distance[a] = wei + b # 이전 노드의 가중치와 현재 노드의 가중치를 더한다.(이제껏 온 거리 + a에서 b로 가는 거리)
            dfs(a, wei + b) # 재귀적으로 연결된 모든 노드를 탐색


# 트리 구현
# 각 노드가 연결된 정보를 트리로 표현
for _ in range(n - 1): #노드가 n이면 간선은 n-1
    a, b, c = map(int, input().split()) #입력받은 값을 쪼개서 map에 저장한다.
    graph[a].append([b, c]) #자식노드 기준으로 b,c넣어서 트리 제작
    graph[b].append([a, c])

# 1번 노드에서 가장 먼 곳을 찾는다.
distance = [-1] * (n + 1) # 탐색확인, 가중치 확인
distance[1] = 0 # 시작 노드는 가중치를 0으로 초기화
dfs(1, 0) # 첫 번째 노드를 dfs 탐색

# 위에서 찾은 노드에 대한 가장 먼 노드를 찾는다.
start = distance.index(max(distance))

# 가장 먼 노드에서 탐색 과정을 거친다.
distance = [-1] * (n + 1) # 탐색확인, 가중치 확인
distance[start] = 0 # 시작 노드는 가중치를 0으로 초기화
dfs(start, 0) # 가장 먼 노드를 dfs 탐색

# 트리의 지름 출력
print(max(distance))
