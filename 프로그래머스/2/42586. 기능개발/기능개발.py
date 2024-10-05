def solution(progresses, speeds):
    import math
    answer = []
    result = 0
    for i in range(len(progresses)):
        sub = 100 - progresses[i]
        day = math.ceil(sub / speeds[i])
        
        if len(answer) == 0:
            answer.append(day)
        elif answer[i-1] > day:
            answer.append(answer[i-1])
        else:
            answer.append(day)
    
    result = list(answer)
    
    lst = []
    for i in range(len(result)):
        if len(lst) == 0:
            lst.append(1)
        elif result[i-1] == result[i]:
            lst[-1] +=1
        else:
            lst.append(1)
    
    return lst