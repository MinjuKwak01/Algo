N, M = map(int, input().split())
lst = list(map(int, input().split()))

end = 0
cnt = 0
summ = 0

for i in range(N):
	while summ < M and end < N:
		summ += lst[end]
		end += 1
	if summ == M:
		cnt += 1
	summ -= lst[i]

print(cnt)