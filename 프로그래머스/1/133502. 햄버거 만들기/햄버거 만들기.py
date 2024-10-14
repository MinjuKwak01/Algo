
def solution(ingredient):
    stack = []
    cnt = 0
    
    for e in ingredient:
        stack.append(e)
        if len(stack) >=4 and stack[-4:] == [1,2,3,1]:
            cnt +=1
            for _ in range(4):
                stack.pop()
        
    return cnt