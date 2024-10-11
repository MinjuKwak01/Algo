N, K = map(int, input().split())

lst = []

for _ in range(N):
    num = int(input())
    lst.append(num)

answer = 0
for i in range(N-1, -1, -1):
    #print(i)
    answer += K // lst[i]
    K = K % lst[i]

print(answer)