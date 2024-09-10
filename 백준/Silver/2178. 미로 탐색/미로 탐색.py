N, M = map(int, input().split())

lst = []
for _ in range(N):
    line = list(map(int,input()))
    lst.append(line)

from collections import deque
def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1 ,1]

    queue = deque()
    queue.append((x,y)) # 시작점

    while queue:
        x, y = queue.popleft()
        # 현재 위치에서 4가지 방향 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if lst[nx][ny] ==0:
                continue
            if lst[nx][ny] ==1:
                lst[nx][ny] = lst[x][y] +1
                queue.append((nx,ny))

    return lst[N-1][M-1]


print(bfs(0,0))