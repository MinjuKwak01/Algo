from collections import deque
def solution(s):
    answer = True
    lst = list(s)
    
    st = deque()
    for e in lst:
        #print(st)
        if e == '(':
            st.append(e)
        elif e == ')' and len(st) != 0:
            gar = st.pop()
            if gar != '(':
                return False
        else:
            return False
    if len(st) != 0:
        return False
                
    return True