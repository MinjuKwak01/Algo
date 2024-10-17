N = int(input())

lst = []

for _ in range(N):
    a, b = map(int, input().split())
    lst.append((a,b))

ans = []
for i in range(N):
    count = 1
    for j in range(N):
        if lst[i][0] < lst[j][0] and lst[i][1] < lst[j][1]:  # 몸무게와 키 모두 자신보다 큰 사람의 수를 센다
            count += 1
    ans.append(count)

for e in ans:
    print(e, end=" ")

