def solution(id_list, report, k):
    answer = []
    dict = {}
    
    report = list(set(report))
    
    for e in id_list:
        dict[e] = 0 #신고 당한 횟수

    for e in report:
        a,b = e.split(" ") # muzi, frodo
        dict[b] +=1 #신고 당한 횟수
    #print(dict)

    banned = []
    for i in dict:
        if dict[i] >= k:
            banned.append(i)
    for e in id_list:
        dict[e] = 0 #다시 초기화

    for e in report:
        a,b = e.split(" ") # muzi, frodo
        if b in banned:
            dict[a] +=1
    for e in dict:
        answer.append(dict[e])
            
    return answer