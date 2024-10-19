def solution(babbling):
    lst = ["aya", "ye", "woo", "ma"]
    
    cnt = 0
    for i in range(len(babbling)):
        for j in lst:
            if j * 2 not in babbling[i]: # 중복되는것 없애기 위함
               # print(babbling[i],j)
                babbling[i]=babbling[i].replace(j,'1')
                
        if babbling[i].isdigit():
            cnt+=1
    
    return cnt