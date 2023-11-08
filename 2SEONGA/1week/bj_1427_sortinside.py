n = int(input()) #입력

li = []
li = list(map(int,str(n))) #숫자를각자리수로나눠리스트로출력
    
li.sort(reverse = True) #내림차순으로정렬
 
for i in li
    print(i,end = '') #출력