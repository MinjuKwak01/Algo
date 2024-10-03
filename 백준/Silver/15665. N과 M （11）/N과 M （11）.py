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

    for i in range(N):
        if prev != lst[i]:
            answer.append(lst[i])
            prev = lst[i]
            back(i+1)
            answer.pop()

back(0)