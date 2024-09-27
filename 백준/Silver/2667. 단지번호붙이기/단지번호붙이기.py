N = int(input())

lst = []
for _ in range(N):
    row = list(input())
    lst.append(row)

dx = [-1,1,0,0]
dy = [0,0,1,-1]

#print(lst)

visited = []
for _ in range(N):
    visited.append([False] * N)

#print(visited)

from collections import deque
def bfs(x, y):
    cnt = 1
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y

            if nx< 0 or nx>= N or ny<0 or ny>= N:
                continue
            if lst[nx][ny] ==0:
                continue
            if lst[nx][ny] == '1' and visited[nx][ny] == False:
                queue.append((nx, ny))
                visited[nx][ny] = True
                cnt +=1
    return cnt

howmany = 0
countlst = []
for i in range(N):
    for j in range(N):
        if lst[i][j] == '1' and visited[i][j] == False:
            count = bfs(i,j)
            howmany += 1
            countlst.append(count)


print(howmany)
countlst.sort()
for e in countlst:
    print(e)