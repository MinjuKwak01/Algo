def solution(array, commands):
    answer = []
    cho = array
    for i in commands:
       # print(i[0])
        array = cho
        array = array[i[0]-1:i[1]]
        array.sort()
        #print(array)
        answer.append(array[i[2]-1])
        
    return answer