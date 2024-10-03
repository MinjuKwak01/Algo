N, M = map(int, input().split())

lst = list(map(int, input().split()))
lst.sort()

visited = [False]* N
answer = []
def back(x):
    prev = 0
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return
    for i in range(x, N):
        if lst[i] != prev and visited[i] == False :
            answer.append(lst[i])
            prev = lst[i]
            visited[i] = True
            back(i+1)
            answer.pop()
            visited[i] = False

back(0)