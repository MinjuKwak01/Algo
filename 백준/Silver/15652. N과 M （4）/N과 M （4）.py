N, M = map(int, input().split())

answer = []

def back(x):
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return

    for i in range(x,N+1):
        answer.append(i)
        back(i)
        answer.pop()

back(1)

