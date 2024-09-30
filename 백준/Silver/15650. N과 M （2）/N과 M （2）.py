N, M = map(int, input().split())

#print(N, M)
answer = []
def back(x):
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return
    else:
        for i in range(x, N+1):
            if i not in answer:
                answer.append(i)
                back(i+1)
                answer.pop()

back(1)
