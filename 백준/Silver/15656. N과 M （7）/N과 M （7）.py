N, M = map(int, input().split())
lst = list(map(int, input().split()))

lst.sort()
answer = []

def back():
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return

    for i in lst:
        answer.append(i)
        back()
        answer.pop()

back()