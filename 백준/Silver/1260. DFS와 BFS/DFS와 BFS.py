N, link, V = map(int, input().split())
graph = []
for _ in range(N+1):
    graph.append([])

for i in range(link):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

vis_1 = [False]*(N+1)
vis_2 = [False]*(N+1)

dfs_visited = []
def dfs(graph, v, vis_1):
    if vis_1[v] == False:
        vis_1[v] = True
    global dfs_visited
    dfs_visited.append(v)

    for i in graph[v]:
        if not vis_1[i]:
            dfs(graph, i, vis_1) # 재귀 사용


bfs_visited = []
from collections import deque
def bfs(graph, v, vis_2):
    queue = deque([v])

    if vis_2[v] == False:
        vis_2[v] = True

    global bfs_visited
    while queue:
        i = queue.popleft()
        bfs_visited.append(i)

        for j in graph[i]:
            if not vis_2[j]:
                queue.append(j)
                vis_2[j] = True

dfs(graph, V, vis_1)
bfs(graph, V, vis_2)

print(*dfs_visited, sep=' ')
print(*bfs_visited, sep=' ')


# from collections import deque
#
# N, M, V = map(int, input().split())
#
# graph = [[False] * (N + 1) for _ in range(N + 1)]
#
# for _ in range(M):
#     a, b = map(int, input().split())
#     graph[a][b] = True
#     graph[b][a] = True
#
# visited1 = [False] * (N + 1)  # dfs의 방문기록
# visited2 = [False] * (N + 1)  # bfs의 방문기록
#
#
# def bfs(V):
#     q = deque([V])  # pop메서드의 시간복잡도가 낮은 덱 내장 메서드를 이용한다
#     visited2[V] = True  # 해당 V 값을 방문처리
#     while q:  # q가 빌때까지 돈다.
#         V = q.popleft()  # 큐에 있는 첫번째 값 꺼낸다.
#         print(V, end=" ")  # 해당 값 출력
#         for i in range(1, N + 1):  # 1부터 N까지 돈다
#             if not visited2[i] and graph[V][i]:  # 만약 해당 i값을 방문하지 않았고 V와 연결이 되어 있다면
#                 q.append(i)  # 그 i 값을 추가
#                 visited2[i] = True  # i 값을 방문처리
#
#
# def dfs(V):
#     visited1[V] = True  # 해당 V값 방문처리
#     print(V, end=" ")
#     for i in range(1, N + 1):
#         if not visited1[i] and graph[V][i]:  # 만약 i값을 방문하지 않았고 V와 연결이 되어 있다면
#             dfs(i)  # 해당 i 값으로 dfs를 돈다.(더 깊이 탐색)
#
#
# dfs(V)
# print()
# bfs(V)