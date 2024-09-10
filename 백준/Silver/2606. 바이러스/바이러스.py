
n:int = int(input())
m:int = int(input())

graph = []
for _ in range(n+1):
    graph.append([]) # [[], [], [], [], []]

for i in range(m):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False]*(n+1)
from collections import deque
def bfs(graph, visited):
    cnt = 0
    queue = deque([1])
    visited[1] = True

    while queue:
        i = queue.popleft()

        for j in graph[i]:
            if not visited[j]:
                queue.append(j)
                #print(j) 노드 수 출력해보기
                visited[j] = True
                cnt += 1

    return cnt


print(bfs(graph,visited))
