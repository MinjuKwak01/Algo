N, M, V = map(int, input().split())
#가로, 세로, 간선 갯수

lst = [[0]* (M) for _ in range(N)]

#print(lst)
for _ in range(V):
    x, y = map(int, input().split())
    lst[x-1][y-1] = 1

from collections import deque

dx = [-1,1,0,0]
dy = [0,0,-1,1]
maximum:int = 0
visited = [[False]* (M) for _ in range(N)]
def bfs(x, y):
    cnt:int = 1
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if lst[nx][ny] ==0:
                continue
            if lst[nx][ny] ==1 and visited[nx][ny] == False:
                queue.append((nx, ny))
                cnt+=1
                visited[nx][ny] = True

    return cnt


for i in range(N):
    for j in range(M):
        if lst[i][j] ==1 and visited[i][j] == False:
            count = bfs(i,j)
            if maximum < count:
                maximum = count

print(maximum)





