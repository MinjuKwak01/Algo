def solution(numbers, hand):
    result = ''
    pad = {'1':(0,0), '2':(0,1), '3':(0,2),
           '4':(1,0), '5':(1,1), '6':(1,2),
           '7':(2,0), '8':(2,1), '9':(2,2),
           '*':(3,0), '0':(3,1), '#':(3,2)
        }
    leftpos = pad['*']
    rightpos = pad['#']
    
    leftdist = 0
    rightdist = 0
    
    for i in range(len(numbers)):
        if numbers[i] == 1 or numbers[i] == 4 or numbers[i] == 7:
            leftpos = pad[str(numbers[i])]
            result += 'L'
            #print("147", numbers[i])
        elif numbers[i] == 3 or numbers[i] == 6 or numbers[i] == 9:
            rightpos = pad[str(numbers[i])]
            result += 'R'
            #print("369", numbers[i])
        else:            
            leftdist = abs(leftpos[0] - pad[str(numbers[i])][0]) + abs(leftpos[1] - pad[str(numbers[i])][1])
            rightdist = abs(rightpos[0] - pad[str(numbers[i])][0]) + abs(rightpos[1] - pad[str(numbers[i])][1])

            if leftdist < rightdist:
                leftpos = pad[str(numbers[i])]
                result += 'L'
            elif leftdist > rightdist:
                rightpos = pad[str(numbers[i])]
                result += 'R'
            else:
                if hand == "right": #오른손잡이
                    rightpos = pad[str(numbers[i])]
                    result += 'R'
                else:
                    leftpos = pad[str(numbers[i])]
                    result += 'L'

    return result