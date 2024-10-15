from collections import deque

def solution(cards1, cards2, goal):
    result = "Yes"
    cur = 0
    dcards1 = deque()
    dcards2 = deque()
    
    for e in cards1:
        dcards1.append(e)
    for e in cards2:
        dcards2.append(e)
        
    for i in range(len(goal)):
        if goal[i] in cards1: #카드1안에 존재한다면
            strr = dcards1.popleft() #pop한 값
            if strr != goal[i]:
                result = "No"
                break
        elif goal[i] in cards2:
            strr = dcards2.popleft() #pop한 값
            if strr != goal[i]:
                result = "No"
                break
        
    return result