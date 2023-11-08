import sys
input = sys.stdin.readline #입력
 
n = int(input()) #숫자로변환
inputList = list(map(int, input().split())) #숫자를각자리수로나눠리스트로출력
tree = [[] for _ in range(n)] #2차원배열생성
 
 
def makeTree(arr, x): #트리생성
    mid = (len(arr)//2) #절반으로분할
    tree[x].append(arr[mid]) #배열의중간값이루트
    if len(arr) == 1: #루트기준왼쪽서브루트와오른쪽서브루트로분할
        return
    makeTree(arr[:mid], x+1)
    makeTree(arr[mid+1:], x+1)
 
 
makeTree(inputList, 0) #서브트리와현재깊이전달
for i in range(k):
    print(*tree[i])