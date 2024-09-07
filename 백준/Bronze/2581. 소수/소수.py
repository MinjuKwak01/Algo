N = int(input())
M= int(input())
lst = []
for i in range(N, M+1):
    if i>1:
        cnt = 0 #약수 개수
        for j in range(2,i):
            if i%j ==0:
                cnt+=1
                break
        if cnt == 0: #약수가 하나라도 없으면 소수이므로 append
            lst.append(i)

if len(lst) == 0:
    print(-1)
else:
    print(sum(lst))
    print(lst[0])
