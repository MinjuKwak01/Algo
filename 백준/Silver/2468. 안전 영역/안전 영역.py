N = int(input())

lst = []
maximum = 0
for _ in range(N):
    row = list(map(int, input().split()))
    lst.append(row)
    maximum = max(row)

from collections import deque

dx = [-1,1,0,0]
dy = [0,0,1,-1]

def bfs(x,y,k):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if nx <0 or nx >=N or ny <0 or ny >= N:
                continue
            if lst[nx][ny] <= k:
                continue
            if lst[nx][ny] > k and visited[nx][ny] == False:
                queue.append((nx, ny))
                visited[nx][ny] = True


result = 1
for k in range(1,maximum):
    count = 0
    visited = []
    for _ in range(N):
        visited.append([False] * N)
    for i in range(N):
        for j in range(N):
          #  print(lst[i][j], visited[i][j])
            if lst[i][j] > k and visited[i][j] == False:
                bfs(i,j,k)
              #  print("bfs : ", i,j,k)
                count +=1

    if result < count:
        result = count

print(result)

