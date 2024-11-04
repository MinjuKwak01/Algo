import sys
from collections import deque
N = int(input())
input = sys.stdin.readline

dq = deque()
for _ in range(N):
    strr = input().split()
    #print(strr)
    a = strr[0]
    if a == "push_back":
        dq.append(strr[1])
    elif a == "push_front":
        dq.appendleft(strr[1])
    elif a == "pop_front":
        if len(dq) == 0:
            print(-1)
        else:
            num = dq.popleft()
            print(num)
    elif a == "pop_back":
        if len(dq) == 0:
            print(-1)
        else:
            num = dq.pop()
            print(num)
    elif a == "size":
        size = len(dq)
        print(size)
    elif a == "empty":
        if len(dq) == 0:
            print(1)
        else:
            print(0)
    elif a == "front":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[0])
    elif a == "back":
        if len(dq) == 0:
            print(-1)
        else:
            print(dq[len(dq)-1])

