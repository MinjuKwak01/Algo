grid = [[0]*100 for _ in range(100)]

for _ in range(4):
    a, b, c, d = map(int, input().split())
    for i in range(a, c):
        for j in range(b, d):
            grid[i-1][j-1] = 1
            
cnt = 0 # 색칠된 grid 영역 count
for k in range(100):
    cnt += sum(grid[k])
print(cnt)