T = int(input())

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(x, y, vis):
    queue = deque()
    queue.append((x,y))
    vis[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if lst[nx][ny] ==0:
                continue
            if lst[nx][ny] == 1 and vis[nx][ny] == False:
                queue.append((nx,ny))
                vis[nx][ny] = True


for _ in range(T):
    M, N, K = map(int, input().split())
    lst = [[0] * M for _ in range(N)] # 가로 M, 세로 N
    vis = [[False] * M for _ in range(N)]
    cnt = 0
    for _ in range(K):
      a,b = map(int, input().split())
      lst[b][a] = 1

  #  print(lst[9][4])

    for i in range(N):
        for j in range(M):
            if lst[i][j] == 1 and vis[i][j] == False:
            #    print(i,j)
                bfs(i,j,vis)
                cnt +=1
    print(cnt)
