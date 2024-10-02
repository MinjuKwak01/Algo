N, M = map(int, input().split())

lst = list(map(int, input().split()))

lst.sort()
answer = []
def back(x):
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return

    for i in range(x, N):
        if lst[i] not in answer:
            answer.append(lst[i])
            back(i+1)
            answer.pop()

back(0)