N, M = map(int, input().split())

lst = list(map(int, input().split()))

lst.sort()
#print(lst)
answer = []
def back():
    if len(answer) == M:
        print(" ".join(map(str, answer)))
        return

    for i in lst:
        if i not in answer:
            answer.append(i)
            #print(answer)
            back()
            #print(answer)
            answer.pop()

back()