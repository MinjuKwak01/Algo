N, M = map(int, input().split())

dx = [-1,1,0,0]
dy= [0,0,-1,1]

lst = []

for i in range(M):
    line = list(map(str, input()))
    lst.append(line)


lst = [[1 if ch == 'W' else 0 for ch in row] for row in lst]


from collections import deque
dx = [-1,1,0,0]
dy = [0,0,1,-1]
visited1 = [[False] * N for _ in range(M)]
visited2 = [[False] * N for _ in range(M)]

def bfs1(x, y):
    cnt = 1
    queue = deque()
    queue.append((x,y))
    visited1[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=M or ny<0 or ny>=N:
                continue
            if lst[nx][ny] == 0:
                continue
            if lst[nx][ny] == 1 and visited1[nx][ny] ==False:
                queue.append((nx, ny))
                visited1[nx][ny] = True
                cnt +=1
    return cnt


def bfs2(x, y):
    cnt = 1
    queue = deque()
    queue.append((x,y))
    visited2[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=M or ny<0 or ny>=N:
                continue
            if lst[nx][ny] == 1:
                continue
            if lst[nx][ny] == 0 and visited2[nx][ny] ==False:
                queue.append((nx, ny))
                visited2[nx][ny] = True
                cnt +=1
    return cnt

sum1 = 0
sum2 = 0
for i in range(M):
    for j in range(N):
        if visited1[i][j] == False and lst[i][j] == 1:
            count1 = bfs1(i,j)
           # print(count)
            sum1 += count1 **2
        if visited2[i][j] == False and lst[i][j] == 0:
            count2 = bfs2(i,j)
            sum2 +=count2 **2

print(sum1, sum2)