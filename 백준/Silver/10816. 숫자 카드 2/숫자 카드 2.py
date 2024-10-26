N = int(input())
nlst = list(map(int, input().split(" ")))

M = int(input())
mlst = list(map(int, input().split(" ")))

카운트리스트 = [0] * 20000001
for i in range(N):
    카운트리스트[nlst[i] + 10000000] += 1

# -10,000,000 이라면 0번째에 저장됨

result = []
for i in range(M):
    result.append(카운트리스트[mlst[i] + 10000000])

for e in result:
    print(e, end=' ')