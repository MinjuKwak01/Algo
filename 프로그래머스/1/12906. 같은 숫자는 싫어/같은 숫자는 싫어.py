from collections import deque
def solution(arr):
    answer = []
    
    for i in range(len(arr)):
        if len(answer) == 0 or arr[i-1] != arr[i]:
           # print(i)
            answer.append(arr[i])

    return answer