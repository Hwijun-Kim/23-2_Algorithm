import sys 
input=sys.stdin.readline
#input을 받는 시간 단축

n=int(input()) #반복 횟수 입력 받기
li=[] #리스트 생성

for i in range(n):# 입력횟수 만큼 반복
    li.append(int(input())) #리스트에 입력값 추가

for i in sorted(li):# 리스트 오름차순 정렬
    print(i)
